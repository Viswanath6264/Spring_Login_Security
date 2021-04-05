package org.studyeasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.studyeasy.model.User;


public interface UserRepository extends JpaRepository<User, Long> 
{
	User findByUsername(String username);
}
