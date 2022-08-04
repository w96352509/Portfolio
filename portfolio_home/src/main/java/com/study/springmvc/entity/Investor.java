package com.study.springmvc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Investor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private Integer blance;
	
	@OneToMany(cascade = CascadeType.REMOVE , mappedBy = "investor")
	@JsonIgnoreProperties("investor")
	private Set<Watch> watchs;
	
	@OneToMany(mappedBy = "investor")
	@JsonIgnoreProperties("investor")
	private Set<Portfoilo> portfoilos;

	public Investor() {
		
	}

	public Investor(String name, String email, Integer blance) {
		
		this.name = name;
		this.email = email;
		this.blance = blance;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBlance() {
		return blance;
	}

	public void setBlance(Integer blance) {
		this.blance = blance;
	}

	public Set<Watch> getWatchs() {
		return watchs;
	}

	public void setWatchs(Set<Watch> watchs) {
		this.watchs = watchs;
	}

	public Set<Portfoilo> getPortfoilos() {
		return portfoilos;
	}

	public void setPortfoilos(Set<Portfoilo> portfoilos) {
		this.portfoilos = portfoilos;
	}
	
	
	
}
