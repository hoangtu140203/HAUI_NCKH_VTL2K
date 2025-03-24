package com.nckh.sentimentalanlysis.repository;

import com.nckh.sentimentalanlysis.model.MainLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MainLinkRepository extends JpaRepository<MainLink, Integer> {
    MainLink findFirstByMainlink(String mainlink);
}
