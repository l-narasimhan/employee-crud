package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.mapper.EmployeePojoMapper;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeResponse;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeePojoMapper employeePojoMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.employeePojoMapper = employeePojoMapper;
    }

    public Optional<EmployeeRequest> getEmployeeById(Integer id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeEntity.isPresent() ? employeePojoMapper.mapToPojo(employeeEntity) : Optional.empty();

    }
    public EmployeeResponse  createEmployee(EmployeeRequest employee) {
        //validaation
        EmployeeEntity employeeEntity = employeeMapper.mapToEntity(employee);
        employeeRepository.save(employeeEntity);
        return EmployeeResponse.builder().employeeId(String.valueOf(employee.getId())).build();
    }




}
