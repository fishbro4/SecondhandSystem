package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods,Integer>{
	
	 @Query(value="select * from goods_tb where gstate = :gstate",nativeQuery=true)	 
	 List<Goods> findByGstate(@Param("gstate") int gstate);
	 
	 @Query(value="select * from goods_tb where uid = :uid and gstate = :gstate",nativeQuery=true)	 
	 List<Goods> findByUidAndGstate(@Param("uid") Integer uid,@Param("gstate") int gstate);
	 
}
