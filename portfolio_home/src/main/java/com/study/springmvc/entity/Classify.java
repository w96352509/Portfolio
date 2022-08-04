package com.study.springmvc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



// 商品類型
@Entity
@Table
public class Classify {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	id;
	
	@Column
	private String name; // 商品類型名稱
	
	@Column
	private Boolean tx;  // 是否支援交易
	
	@OneToMany(mappedBy = "classify")
	@JsonIgnoreProperties("classify")
	private Set<TStock> tStocks;

	public Classify() {
		
	}
	
	public Classify(String name, boolean tx) {
		this.name = name;
		this.tx = tx;
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

	public boolean isTx() {
		return tx;
	}

	public void setTx(Boolean tx) {
		this.tx = tx;
	}

	public Set<TStock> getTstocks() {
		return tStocks;
	}

	public void setTstocks(Set<TStock> tstocks) {
		this.tStocks = tstocks;
	}
	
	
}
