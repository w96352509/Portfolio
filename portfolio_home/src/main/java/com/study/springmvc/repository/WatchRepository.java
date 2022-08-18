package com.study.springmvc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springmvc.entity.Watch;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Watch SET name=?1 WHERE investor_id=?2")
	public void UpdateInvestorId(@Param("name") String name, @Param("id") Integer id);		

	
}
