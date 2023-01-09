package com.EmployeeMgmt.service.impl;

import org.springframework.stereotype.Service;

import com.EmployeeMgmt.entity.Empentity;
import com.EmployeeMgmt.repository.EmpRepo;

@Service
public class EmpServiceimpl implements EmpService  {
private EmpRepo employeeRepository;
	
	public EmpServiceimpl(EmpRepo employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}

	@Override
	public java.util.List<Empentity> listEmpentity() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Empentity saveEmployee(Empentity employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Empentity updateEmployee(Empentity employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Empentity getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}	

	
	}
	