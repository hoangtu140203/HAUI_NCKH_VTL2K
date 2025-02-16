package com.nckh.UserSercvice.repository;

import com.nckh.UserSercvice.model.Authen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenRepository extends JpaRepository<Authen, Long> {
}
