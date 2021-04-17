package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.model.EmployeeResponse;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

/**
 * Implementation class for employee resource.
 */
@Slf4j
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeResourceImpl(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<EmployeeRequest>  getEmployeeById(String id) {
        Optional<EmployeeRequest> employee;
        try {
             employee = employeeService.getEmployeeById(Integer.valueOf(id));
        }catch (Exception e) {
            log.error("Failed to retrieve employee record " + id, e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return employee.map(v -> new ResponseEntity<>(v, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        /*
         Check if the Employee id is already available
         */
        EmployeeResponse employeeResponse;
        Long startTime = System.currentTimeMillis();
        Optional<EmployeeRequest> emp = employeeService.getEmployeeById(employeeRequest.getId());
        if (emp.isPresent()){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        try {
             employeeResponse = employeeService.createEmployee(employeeRequest);
        }catch (Exception e) {
            log.error("Failed to Create New Employee " + employeeRequest.getFirstName(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                replacePath("/v1/bfs/employees/").path("/{id}").buildAndExpand(employeeRequest.getId()).toUri();
        log.info("Employee Creation Successful Time taken {}", System.currentTimeMillis() - startTime);
        return  ResponseEntity.created(location).body(employeeResponse);
    }
}
