package com.EmployeeMgmt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.EmployeeMgmt.entity.Empentity;
import com.EmployeeMgmt.service.impl.EmpService;



@Controller
public class EmpController {
	private EmpService employeeService;

	public EmpController(EmpService employeeService) {
			
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) {

		List<Empentity> employees = employeeService.listEmpentity();

		model.addAttribute("employees", employees);

		return "employees";
	}

	// Add Employee - START
	@GetMapping("/employees/new")
	public String addEmployeeButtonClicked(Model model) {

		Empentity employee = new Empentity();
		model.addAttribute("employee", employee);

		return "create_employee";
	}

	@PostMapping("/employees")
	public String submitButtonClickedForAddEmpentity(@ModelAttribute("employee") Empentity employee) {

		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	// Add Employee - END

	// Update Employee - Start
	@GetMapping("/employees/edit/{id}")
	public String updateEmpentityButtonClicked(@PathVariable Long id, Model model) {

		Empentity selectedEmployee = employeeService.getEmployeeById(id);

		model.addAttribute("employee", selectedEmployee);

		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String submitButtonClickedForUpdateEmployee(@PathVariable Long id,
			@ModelAttribute("employee") Empentity employee) {

		// Update the employee object
		Empentity existingEmployeeObj = employeeService.getEmployeeById(id);

		existingEmployeeObj.setFirstName(employee.getFirstName());
		existingEmployeeObj.setLastName(employee.getLastName());
		existingEmployeeObj.setEmail(employee.getEmail());

		employeeService.updateEmployee(employee);

		return "redirect:/employees";
	}

	// Update Employee details - End

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {

		employeeService.deleteById(id);
		return "redirect:/employees";
	}
}