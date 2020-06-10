package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//import lombok.Data;


@Entity(name = "user_tb")
//@Table(name = "user_tb")//重新映射表名
//@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	private String uname;
	private String upassword;
	private int ulever;
	private String uphone;
	private String uemail;
	private String uaddress;
	
	@Column
    @OneToMany(mappedBy = "user")
    //@JsonIgnoreProperties({"user","product"})
    private List<Buy> orders;

	public int getUlever() {
		return ulever;
	}

	public void setUlever(int ulever) {
		this.ulever = ulever;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
	public boolean isTruePassword(String upassword){
        if (upassword.equals(this.upassword)){
            return true;
        } else {
            return false;
        }
    }

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	
	
}