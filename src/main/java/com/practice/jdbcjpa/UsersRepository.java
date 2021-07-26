package com.practice.jdbcjpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
	Optional<Users> findByUserName(String userName);
}
