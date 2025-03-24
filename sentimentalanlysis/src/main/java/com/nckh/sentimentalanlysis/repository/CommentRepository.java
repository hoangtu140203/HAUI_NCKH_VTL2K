package com.nckh.sentimentalanlysis.repository;

import com.nckh.sentimentalanlysis.dto.Response.PercentageAnalysis;
import com.nckh.sentimentalanlysis.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost_LinkId(Integer link_Id);

    @Query(value = """
        SELECT c.sen_analysis AS senAnalysis, 
               COUNT(*) * 100.0 / (SELECT COUNT(*) FROM comments WHERE link_id = :linkId) AS percentage
        FROM comments c
        WHERE c.link_id = :linkId 
          AND c.sen_analysis IN ('NEGATIVE', 'POSITIVE', 'NEUTRAL')
        GROUP BY c.sen_analysis
        """, nativeQuery = true)
    List<Object[]> getSentimentPercentageByLinkId(@Param("linkId") Integer linkId);




    @Query(value = """
        SELECT sen_analysis, COUNT(*) AS comment_count
        FROM comments
        WHERE link_id = :linkId
        GROUP BY sen_analysis
        UNION ALL
        SELECT 'NEGATIVE', 0
        WHERE NOT EXISTS (SELECT 1 FROM comments WHERE link_id = :linkId AND sen_analysis = 'NEGATIVE')
        UNION ALL
        SELECT 'POSITIVE', 0
        WHERE NOT EXISTS (SELECT 1 FROM comments WHERE link_id = :linkId AND sen_analysis = 'POSITIVE')
        UNION ALL
        SELECT 'NEUTRAL', 0
        WHERE NOT EXISTS (SELECT 1 FROM comments WHERE link_id = :linkId AND sen_analysis = 'NEUTRAL');
        """, nativeQuery = true)
    List<Object[]> getSentimentNumberByLinkId(@Param("linkId") Integer linkId);

}
