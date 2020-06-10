package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public boolean login(String uname, String upassword){
		User user = userRepository.findByUname(uname);
		return user.isTruePassword(upassword);
	}

	public User getUserByName(String username){
		return userRepository.findByUname(username);
	}
	
	public boolean addUser(String uname, String upassword, String uphone, String uemail, String uaddress){
        User user = new User();
        user.setUname(uname);
        user.setUpassword(upassword);
        user.setUlever(1);
        user.setUphone(uphone);
        user.setUemail(uemail);
        user.setUaddress(uaddress);
        userRepository.save(user);
        return true;
    }
	
	public List<User> findAllByUlever(int ulever){
        return userRepository.findAllByUlever(ulever);
    }
}
