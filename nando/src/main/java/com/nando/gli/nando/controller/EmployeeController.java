package com.nando.gli.nando.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.validation.Valid;

import com.nando.gli.nando.exception.ResourceNotFoundException;
import com.nando.gli.nando.model.Employee;
import com.nando.gli.nando.repository.EmployeeRepository;
import com.nando.gli.nando.utils.Utils;
import com.nando.gli.nando.vo.EmployeeDetailVO;
import com.nando.gli.nando.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List <Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeVO vo) {
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        int rand2 = rand.nextInt(5);
        int[] random_role_id = {1,2,3,4,5};

        String dob_temp = Utils.getCurrentDateToString();
        String[] random_role_name = {"Staff","Manager","Cashier","Receptionist","Security"};
        String[] address_array = {"Bogor","Jakarta","Palembang","Surabaya","Malang"};

        Employee employee = new Employee();
        employee.setFullName(vo.getFullName());
        employee.setDob(vo.getDob());
        employee.setSalary(vo.getSalary());
        employee.setAddress(address_array[rand2]);
        employee.setRoleId(random_role_id[rand1]);
        employee.setRoleName(random_role_name[rand1]);
        employee.setDob(dob_temp);

        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                      @Valid @RequestBody EmployeeDetailVO vo) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        String[] random_role_name = {"Staff","Manager","Cashier","Receptionist","Security"};
        employee.setId(employeeId);
        employee.setFullName(vo.getFullName());
        employee.setAddress(vo.getAddress());
        employee.setDob(vo.getDob());
        employee.setRoleId(vo.getRoleId());
        employee.setRoleName(random_role_name[vo.getRoleId()]);
        employee.setSalary(vo.getSalary());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
