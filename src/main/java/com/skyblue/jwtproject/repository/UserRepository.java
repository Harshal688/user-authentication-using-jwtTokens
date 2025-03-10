package com.skyblue.jwtproject.repository;

import com.skyblue.jwtproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
}
