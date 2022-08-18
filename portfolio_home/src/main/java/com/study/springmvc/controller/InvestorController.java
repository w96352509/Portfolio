package com.study.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springmvc.entity.Investor;
import com.study.springmvc.entity.Watch;
import com.study.springmvc.repository.InvestorRepository;
import com.study.springmvc.repository.WatchRepository;

@RestController
@RequestMapping("/investor")
public class InvestorController {

	@Autowired
	private InvestorRepository investorRepository;
	
	@Autowired
	private WatchRepository watchRepository;
	
	@GetMapping("/")
	public List<Investor> queryAll() {
	  return investorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Investor get(@PathVariable("id") Integer id) {
		Optional<Investor> optInvestor = investorRepository.findById(id);
		return optInvestor.isPresent() ? optInvestor.get() : null;
	}
	
	@PostMapping("/")
	@Transactional
	public Investor add(@RequestBody Map<String, String> map) {
		Investor investor = new Investor();
		investor.setUsername(map.get("username"));
		investor.setEmail(map.get("email"));
		investor.setBalance(Integer.parseInt(map.get("balance")));
		
		// Watch
		String watchName = investor.getUsername();
		Watch watch = new Watch();
		watch.setName(watchName);
		watch.setInvestor(investor);
		watchRepository.save(watch);
	    
		return investorRepository.save(investor);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Investor update(@PathVariable("id") Integer id,@RequestBody Map<String, String> map) {
		Investor investor = get(id);
		if(investor == null) {
			return null;
		}
		investor.setUsername(map.get("username"));
		investor.setBalance(Integer.parseInt(map.get("balance")));
		investor.setEmail(map.get("email"));
		
		// 修改 Watch 名稱
		watchRepository.UpdateInvestorId(map.get("username"), id);
		investorRepository.saveAndFlush(investor);
	 	return investor;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public Boolean delete(@PathVariable("id") Integer id) {
		Investor investor = get(id);
		if(investor == null) {
			return false;
		}
		investorRepository.deleteById(id);
		return true;
	}
	
}
