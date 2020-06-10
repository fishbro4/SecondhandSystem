package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.GoodsRepository;
import com.example.demo.service.GoodsService;
import com.example.demo.utils.Message;

@RestController
public class GoodsHandler {
	
	@Autowired
    GoodsService goodsService;
	
	@GetMapping("/goods/findAllGoods")
	public Message findAllGoods(){
		return Message.ok(goodsService.findGoodsByState(2));
	}
	
    @GetMapping("/goods/add")
    public Message addGoods(String gname, String gpicture, String gtext, Double gprice, Integer uid){
        goodsService.addGoods(gname,gpicture,gtext,gprice,uid);
        return Message.ok();
    }
    
    @GetMapping("/goods/release")
    public Message release(Integer gid){
        goodsService.updataState(gid,2);
        return Message.ok();
    }
    
    @GetMapping("/goods/findAllByState")
    public Message findGoodsByState(int gstate){
        return Message.ok(goodsService.findGoodsByState(gstate));
    }
    
    @GetMapping("/goods/findByUidAndGstate")
    public Message findByUidAndGstate(Integer uid,int gstate){
        return Message.ok(goodsService.findByUidAndGstate(uid,gstate));
    }
}
