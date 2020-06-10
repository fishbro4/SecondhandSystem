package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Buy;


public interface BuyRepository extends JpaRepository<Buy,Integer>{
	@Query(value="select * from buy_tb where uid = :uid",nativeQuery=true)
    List<Buy> findAllByUid(@Param("uid") Integer uid);
}
