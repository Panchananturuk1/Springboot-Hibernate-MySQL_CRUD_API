package form.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> emplist = new ArrayList<>();
		employeeRespository.findAll().forEach(emplist::add);
		return new ResponseEntity<List<Employee>>(emplist,HttpStatus.OK);
	}
	
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
		Optional<Employee> emp = employeeRespository.findById(empid);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//			return "Employee detail not found";
		}	
	}
	
	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
		Optional<Employee> emp = employeeRespository.findById(empid);
		if(emp.isPresent()) {
			Employee existEmp = emp.get();
			existEmp.setEmp_age(employee.getEmp_age());
			existEmp.setEmp_city(employee.getEmp_city());
			existEmp.setEmp_name(employee.getEmp_name());
			existEmp.setEmp_salary(employee.getEmp_salary());
			employeeRespository.save(existEmp);
			return "Employee details againts Id" + empid +"Updated";
			
		}else {
			return "Employee details does not exists"+empid;
		}
	}
	
	@DeleteMapping("/employees/{empid}")
	public String deleteEmployeeById(@PathVariable long empid){
		employeeRespository.deleteById(empid);
		return "Employee Deleted Sucessfully";
	}
	
	@DeleteMapping("/employees")
	public String deleteAllEmplyee() {
		employeeRespository.deleteAll();
		return "All employees Deleted";
	}

}
