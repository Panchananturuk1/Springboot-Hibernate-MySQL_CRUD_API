package form.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empid;
	
	@Column(name ="emp_name")
	private String emp_name;
	
	@Column(name ="emp_salary")
	private Float emp_salary;
	
	@Column(name ="emp_age")
	private int emp_age;
	
	@Column(name ="emp_city")
	private String emp_city;

	
	public Long getEmpid() {
		return empid;
	}

	
	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	
	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	
	public Float getEmp_salary() {
		return emp_salary;
	}

	
	public void setEmp_salary(Float emp_salary) {
		this.emp_salary = emp_salary;
	}

	
	public int getEmp_age() {
		return emp_age;
	}

	
	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}

	
	public String getEmp_city() {
		return emp_city;
	}

	
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}

	public Employee(Long empid, String emp_name, Float emp_salary, int emp_age, String emp_city) {
		super();
		this.empid = empid;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_age = emp_age;
		this.emp_city = emp_city;
	}
	
	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", emp_age="
				+ emp_age + ", emp_city=" + emp_city + "]";
	}
	
	
	

}
