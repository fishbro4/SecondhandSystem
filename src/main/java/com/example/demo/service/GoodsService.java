package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Goods;
import com.example.demo.entity.User;
import com.example.demo.repository.GoodsRepository;
import com.example.demo.repository.UserRepository;

@Service
public class GoodsService {
	
	@Autowired
	GoodsRepository goodsRepository;
	
	@Autowired
    UserRepository userRepository;
	
	public List<Goods> findGoodsByState(int gstate){
        return goodsRepository.findByGstate(gstate);
    }
	
	public boolean addGoods(String gname, String gpicture, String gtext, Double gprice, Integer uid){
        Goods goods = new Goods();
        goods.setGname(gname);
        goods.setGpicture(gpicture);
        goods.setGtext(gtext);
        goods.setGprice(gprice);//注意类型
        goods.setGstate(1);
        Optional<User> userFindResult = userRepository.findById(uid);
        goods.setFounder(userFindResult.get());
        goodsRepository.save(goods);
        return true;
    }
	
	public void updataState(Integer gid, int state){
        Goods goods = goodsRepository.findById(gid).get();
        goods.setGstate(state);
        goodsRepository.save(goods);
    }
	
	public List<Goods> findByUidAndGstate(Integer uid,int gstate){
		return goodsRepository.findByUidAndGstate(uid,gstate);
	}
	
}
