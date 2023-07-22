package form.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import form.crud.model.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

}
