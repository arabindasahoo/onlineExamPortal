package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
