package com.nando.gli.nando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nando.gli.nando.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
