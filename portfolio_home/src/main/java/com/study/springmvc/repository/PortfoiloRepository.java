package com.study.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springmvc.entity.Portfoilo;

@Repository
public interface PortfoiloRepository extends JpaRepository<Portfoilo, Integer> {

}
