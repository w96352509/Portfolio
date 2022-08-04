package com.study.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springmvc.entity.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {

}
