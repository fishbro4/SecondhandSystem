package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "buy_tb")
public class Buy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bid;
	private String bway;
	private int bstate;
	
	@ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
   // @JsonIgnoreProperties({"orders"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    //@JsonIgnoreProperties({"orders"})
    private Goods goods;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBway() {
		return bway;
	}

	public void setBway(String bway) {
		this.bway = bway;
	}

	public int getBstate() {
		return bstate;
	}

	public void setBstate(int bstate) {
		this.bstate = bstate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
    
    
}
