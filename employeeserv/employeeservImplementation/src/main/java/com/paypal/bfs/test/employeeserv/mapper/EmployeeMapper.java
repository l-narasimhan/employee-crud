package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.AddressRequest;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public EmployeeEntity mapToEntity(EmployeeRequest employee) {
        return EmployeeEntity.builder().employeeId(employee.getId())
                .firstName(employee.getFirstName()).lastName(employee.getLastName())
                .dob(employee.getDob())
                .address(employee.getAddress() != null ? getAddressEntity(employee.getAddress(), employee.getId()) : null)
                .build();
    }

    private AddressEntity getAddressEntity(AddressRequest addressRequest, Integer id) {
        return AddressEntity.builder().addLine1(addressRequest.getAddressLine1()).addLine2(addressRequest.getAddressLine2())
                .employeeId(id)
                .city(addressRequest.getCity()).country(addressRequest.getCountry()).state(addressRequest.getState())
                .zip(addressRequest.getZip()).build();

    }
}
