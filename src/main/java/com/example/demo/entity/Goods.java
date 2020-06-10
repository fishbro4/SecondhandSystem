package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "goods_tb")
public class Goods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gid;
	private String gname;
	private String gpicture;
	private String gtext;
	private double gprice;
	private int gstate;
	private String rdare;
	private String gconment;
	
	@Column
    @OneToMany(mappedBy = "goods")
    private List<Buy> orders;
	
	@ManyToOne
	@JoinColumn(name = "uid", referencedColumnName = "uid")
    private User founder;
	
	public List<Buy> getOrders() {
		return orders;
	}
	public void setOrders(List<Buy> orders) {
		this.orders = orders;
	}
	public User getFounder() {
		return founder;
	}
	public void setFounder(User founder) {
		this.founder = founder;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}
	public String getGtext() {
		return gtext;
	}
	public void setGtext(String gtext) {
		this.gtext = gtext;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public int getGstate() {
		return gstate;
	}
	public void setGstate(int gstate) {
		this.gstate = gstate;
	}
	public String getRdare() {
		return rdare;
	}
	public void setRdare(String rdare) {
		this.rdare = rdare;
	}
	public String getGconment() {
		return gconment;
	}
	public void setGconment(String gconment) {
		this.gconment = gconment;
	}
	
	
}
