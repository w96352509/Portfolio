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

import com.study.springmvc.entity.Classify;
import com.study.springmvc.repository.ClassifyRepository;

/* 
 * -------------------------------------------------
 * METHOD PATH                     Desp
 * -------------------------------------------------
 * GET    {"/", "/query"}          查詢全部資料
 * GET    {"/{id}", "/get/{id}"}    查詢單筆資料
 * POST   {"/", "/add"}            新增資料
 * PUT    {"/{id}", "/update/{id}"} 修改資料(根據ID)
 * DELETE {"/{id}", "/delete/{id}"} 刪除資料(根據ID)
 * -------------------------------------------------
*/

@RestController
@RequestMapping("/classify")
public class ClassifyController {
	
	@Autowired
	private ClassifyRepository classifyRepository;
	
	@GetMapping("/")
	public List<Classify> findAll() {
		return classifyRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Classify get(@PathVariable("id") Integer id) {
		Optional<Classify> optClassify = classifyRepository.findById(id);
		return optClassify.isPresent()?optClassify.get():null;
	}
	
	@PostMapping("/")
	public Classify add(@RequestBody Map<String, String> map) {
		Classify classify = new Classify();
		classify.setName(map.get("name"));
		if(map.get("tx")==null) {
			classify.setTx(false);
		}
		classify.setTx(true);
		classify = classifyRepository.save(classify);
		return classify ;
	}
	
}
