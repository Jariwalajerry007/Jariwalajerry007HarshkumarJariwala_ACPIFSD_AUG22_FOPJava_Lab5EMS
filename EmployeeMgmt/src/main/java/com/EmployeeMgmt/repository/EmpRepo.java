package com.EmployeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeMgmt.entity.Empentity;

public interface EmpRepo 

	extends JpaRepository<Empentity, Long>{

}
