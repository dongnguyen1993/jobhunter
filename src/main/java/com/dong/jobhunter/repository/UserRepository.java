package com.dong.jobhunter.repository;

import com.dong.jobhunter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
