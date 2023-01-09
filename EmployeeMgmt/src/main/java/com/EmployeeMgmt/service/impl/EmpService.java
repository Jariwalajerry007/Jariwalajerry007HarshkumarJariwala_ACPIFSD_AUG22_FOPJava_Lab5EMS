package com.EmployeeMgmt.service.impl;

import java.util.List;

import com.EmployeeMgmt.entity.Empentity;

public interface EmpService {
List<Empentity> listEmpentity();
	
Empentity saveEmployee(Empentity employee);
	
	// Update - Start	
Empentity updateEmployee(Empentity employee);
	
Empentity getEmployeeById(Long id);	
	//  Update - End
	
	void deleteById(Long id);
}