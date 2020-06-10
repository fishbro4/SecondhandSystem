package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.configurationprocessor.json.JSONException;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.Message;

@RestController
//@RequestMapping("/user")
public class UserHandler {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/login")
    public Message login(@RequestBody JSONObject json){
        String username = (String) json.get("name");
        String password = (String) json.get("password");
        if (userService.login(username,password)) {
            return Message.ok(userService.getUserByName(username),"登录成功");
        } else {
            return Message.error(511, "登录失败");
        }
    }
	
	@GetMapping("/user/add")
    public Message adduser(String uname, String upassword, String uphone, String uemail, String uaddress){
		userService.addUser(uname, upassword, uphone, uemail, uaddress);
        return Message.ok();
    }
	
	@GetMapping("/user/findAll")
	public Message findAll(int ulever){
		return Message.ok(userService.findAllByUlever(ulever));
	}
}

