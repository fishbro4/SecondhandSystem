package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BuyService;
import com.example.demo.utils.Message;


@RestController
public class BuyHandle {
	
	@Autowired
    BuyService buyService;

    @GetMapping("/buy")
    public Message buy(Integer uid, Integer gid){
        if (buyService.buy(uid,gid)){
            return Message.ok();
        } else {
            return Message.error();
        }
    }

    @GetMapping("/buy/findByUid")
    public Message findByUid(Integer uid){
        return Message.ok(buyService.findBuyByUid(uid));
    }
}
