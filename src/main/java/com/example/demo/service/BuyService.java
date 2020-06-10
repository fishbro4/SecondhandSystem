package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Buy;
import com.example.demo.entity.Goods;
import com.example.demo.entity.User;
import com.example.demo.repository.BuyRepository;
import com.example.demo.repository.GoodsRepository;
import com.example.demo.repository.UserRepository;


@Service
public class BuyService {
	@Autowired
    BuyRepository buyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsService goodsService;

    public boolean buy(Integer uid, Integer gid){
        User user = userRepository.findById(uid).get();
        Goods goods = goodsRepository.findById(gid).get();
        Buy buy = new Buy();
        buy.setUser(user);
        buy.setGoods(goods);
        buy.setBway("线上交易");
        goodsService.updataState(gid,3);
        buyRepository.save(buy);
        return true;
    }
    
    public List<Buy> findBuyByUid(Integer uid){
    	return buyRepository.findAllByUid(uid);
    }
}
