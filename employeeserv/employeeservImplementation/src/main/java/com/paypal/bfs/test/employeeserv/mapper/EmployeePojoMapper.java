package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.AddressRequest;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeePojoMapper {
    public Optional<EmployeeRequest> mapToPojo(Optional<EmployeeEntity> employeeEntity) {
       return employeeEntity.map(entity -> EmployeeRequest.builder().id(entity.getEmployeeId())
               .firstName(entity.getFirstName())
               .lastName(entity.getLastName())
               .dob(entity.getDob())
               .address(getAddressPojo(entity.getAddress())).build());

    }

    private AddressRequest getAddressPojo(AddressEntity addressEntity) {
        AddressRequest address = new AddressRequest();
        if (addressEntity != null) {
            address.setAddressLine1(addressEntity.getAddLine1());
            address.setAddressLine2(addressEntity.getAddLine2());
            address.setCity(addressEntity.getCity());
            address.setState(addressEntity.getState());
            address.setCountry(addressEntity.getCountry());
            address.setZip(addressEntity.getZip());
        }
        return address;
    }

}
