package com.spring.angularbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.angularbackend.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
