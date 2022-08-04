package com.study.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springmvc.entity.Classify;

@Repository
public interface ClassifyRepository extends JpaRepository<Classify, Integer> {

}
