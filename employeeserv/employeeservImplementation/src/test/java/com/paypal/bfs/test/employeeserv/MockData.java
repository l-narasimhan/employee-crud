package com.paypal.bfs.test.employeeserv;

import com.paypal.bfs.test.employeeserv.api.model.AddressRequest;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeResponse;

import java.util.Optional;

public class MockData {
    public static Optional<EmployeeRequest> getEmployee() {
        EmployeeRequest req = EmployeeRequest.builder().id(1001)
                .firstName("firstname")
                .lastName("lastname")
                .dob("2021-12-13")
                .address(getAddress()).build();
        return Optional.of(req);
    }

    public static EmployeeRequest getEmployee1() {
        EmployeeRequest req = EmployeeRequest.builder().id(1001)
                .firstName("firstname")
                .lastName("lastname")
                .dob("2021-12-13")
                .address(getAddress()).build();
        return(req);
    }

    public  static EmployeeRequest getEmployeeJson() {
        return EmployeeRequest.builder().id(1001)
                .firstName("firstname")
                .lastName("lastname")
                .dob("2021-12-13")
                .address(getAddress()).build();


    }

    private static AddressRequest getAddress() {
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setAddressLine1("Line 1 Address");
        addressRequest.setAddressLine2("Line 2 Address");
        addressRequest.setCity("Melb");
        addressRequest.setState("vic");
        addressRequest.setCountry("Aus");
        addressRequest.setZip("111");
        return addressRequest;
    }

    public  static EmployeeRequest getInvalidFirstName() {
        return EmployeeRequest.builder().id(5000)
                .firstName("4567")
                .build();
    }
    public  static EmployeeRequest getInvalidFirstNameNull() {
        return EmployeeRequest.builder().id(5000)
                .firstName(null)
                .build();
    }

    public  static EmployeeRequest getInvalidLastName() {
        return EmployeeRequest.builder().id(5000)
                .firstName("abcd")
                .lastName("8888")
                .build();
    }

    public  static EmployeeRequest getInvalidDob() {
        return EmployeeRequest.builder().id(5000)
                .firstName("abcd")
                .lastName("efgh")
                .dob("55/34/34")
                .build();
    }

    public  static EmployeeRequest getInvalidAddline1() {
        return EmployeeRequest.builder().id(5000)
                .firstName("abcd")
                .lastName("efgh")
                .dob("2021-12-13")
                .address(getInvalidLine1())
                .build();
    }

    public  static EmployeeRequest getInvalidAddline2() {
        return EmployeeRequest.builder().id(5000)
                .firstName("abcd")
                .lastName("efgh")
                .dob("2021-12-13")
                .address(getInvalidLine2())
                .build();
    }

    private static AddressRequest getInvalidLine1() {
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setAddressLine1(null);
        addressRequest.setAddressLine2("Line 2 Address");
        addressRequest.setCity("Melb");
        addressRequest.setState("vic");
        addressRequest.setCountry("Aus");
        addressRequest.setZip("111");
        return addressRequest;
    }

    private static AddressRequest getInvalidLine2() {
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setAddressLine1("Collins Street");
        addressRequest.setAddressLine2("");
        addressRequest.setCity("Melb");
        addressRequest.setState("vic");
        addressRequest.setCountry("Aus");
        addressRequest.setZip("111");
        return addressRequest;
    }

    private static AddressRequest getInvalidZip() {
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setAddressLine1("");
        addressRequest.setAddressLine2("Line 2 Address");
        addressRequest.setCity("Melb");
        addressRequest.setState("vic");
        addressRequest.setCountry("Aus");
        addressRequest.setZip("abcd");
        return addressRequest;
    }

    public  static EmployeeRequest getInvalidCity() {
        return EmployeeRequest.builder().id(5000)
                .firstName("abcd")
                .lastName("efgh")
                .dob("2021-12-13")
                .address(getInvalidCity1())
                .build();
    }

    private static AddressRequest getInvalidCity1() {
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setAddressLine1("");
        addressRequest.setAddressLine2("Line 2 Address");
        addressRequest.setCity("");
        addressRequest.setState("vic");
        addressRequest.setCountry("AU");
        addressRequest.setZip("111");
        return addressRequest;
    }

    public  static EmployeeRequest getInvalidState() {
        return EmployeeRequest.builder().id(5000)
                .firstName("abcd")
                .lastName("efgh")
                .dob("2021-12-13")
                .address(getInvalidState1())
                .build();
    }

    private static AddressRequest getInvalidState1() {
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setAddressLine1("");
        addressRequest.setAddressLine2("Line 2 Address");
        addressRequest.setCity("");
        addressRequest.setState("vic");
        addressRequest.setCountry("AU");
        addressRequest.setZip("111");
        return addressRequest;
    }

    public  static EmployeeRequest getInvalidCountry() {
        return EmployeeRequest.builder().id(5000)
                .firstName("abcd")
                .lastName("efgh")
                .dob("2021-12-13")
                .address(getInvalidCountry1())
                .build();
    }

    private static AddressRequest getInvalidCountry1() {
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setAddressLine1("");
        addressRequest.setAddressLine2("Line 2 Address");
        addressRequest.setCity("Melb");
        addressRequest.setState("vic");
        addressRequest.setCountry("");
        addressRequest.setZip("111");
        return addressRequest;
    }


    public  static EmployeeRequest getInvalidEmpId() {
        return EmployeeRequest.builder().id(null).build();

    }

    public static EmployeeResponse getEmployeeResponse() {
        return  EmployeeResponse.builder().employeeId("5000").build();

    }

    public static EmployeeEntity getEmpEntity() {
        return EmployeeEntity.builder().employeeId(5000)
                .firstName("first_name").lastName("last_name").build();
    }

    private static AddressEntity getAddressEntity() {
        AddressEntity addEnt = new AddressEntity();
        addEnt.setAddLine1("Line 1 Address");
        addEnt.setAddLine2("Line 2 Address");
        addEnt.setCity("Melbourne");
        addEnt.setCountry("Aus");
        addEnt.setZip("111");
        return addEnt;
    }

    public static EmployeeEntity getEmpEntityWithAddress() {
        return EmployeeEntity.builder().employeeId(5000)
                .firstName("first_name").lastName("last_name")
                .dob("2021-12-12")
                .address(getAddressEntity()).build();
    }
}
