package com.devsuperior.aulajparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.aulajparepository.entitie.User;

public interface UserRepository extends JpaRepository<User,Long> {



	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> SearchName(String name, Pageable pageable);
	
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
	
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
	

}
