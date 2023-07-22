package form.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import form.crud.model.Employee;
import form.crud.repository.EmployeeRespository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRespository employeeRespository;
	
	@PostMapping("/employees")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRespository.save(employee);
		return "Employee created in database";
	}

}
