package com.study.springmvc.entity;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Watch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "investor_id" , referencedColumnName = "id")
	@JsonIgnoreProperties("watchs")
	private Investor investor ;
	
	//  FetchType 除非真正要使用到該屬性的值，否則不會真正將資料從表格中載入物件
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "wath_tstock",
	joinColumns = {
			@JoinColumn(name = "watch_id" , nullable = false , updatable = false)
	        }, 
	inverseJoinColumns = {
			@JoinColumn(name = "tStock_id" , nullable = false , updatable = false)
	        } 
	)
	private Set<TStock> tStocks = new CopyOnWriteArraySet<>();

	public Watch() {
		
	}

	public Watch(String name, Investor investor) {
		
		this.name = name;
		this.investor = investor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public Set<TStock> gettStock() {
		return tStocks;
	}

	public void settStock(Set<TStock> tStock) {
		this.tStocks = tStock;
	}
	
	// 加入股市進清單
	public Set<TStock> addtStock(TStock tStock) {
        tStocks.add(tStock);
        return tStocks;
    }
    
    public Set<TStock> removetStock(TStock tStock) {
        tStocks.remove(tStock);
        return tStocks;
    }
	
}
