package com.study.springmvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Portfoilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer cost;
	
	@Column
	private Integer amount;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();
	
	@ManyToOne
	@JoinColumn(name = "inverstor_id" , referencedColumnName = "id")
	@JsonIgnoreProperties("portfoilos")
	private Investor investor;
	
	// 約束模式
	@OneToOne
	@JoinColumn(name="tStock_id" , foreignKey = @ForeignKey(name="tStock_fk" , value = ConstraintMode.CONSTRAINT))
	private TStock tStock;

	public Portfoilo() {
		
	}

	public Portfoilo(Integer cost, Integer amount, Investor investor, TStock tStock) {
		this.cost = cost;
		this.amount = amount;
		this.investor = investor;
		this.tStock = tStock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public TStock gettStock() {
		return tStock;
	}

	public void settStock(TStock tStock) {
		this.tStock = tStock;
	}
	
	
	
}
