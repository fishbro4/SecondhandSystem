package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUname(String uname);
	
	@Query(value="select * from user_tb where ulever = :ulever",nativeQuery=true)
    List<User> findAllByUlever(@Param("ulever") int ulever);
	
}
