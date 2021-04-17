package com.paypal.bfs.test.employeeserv.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "Employee_Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer addressId;
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "ADD_LINE1")
    private String addLine1;
    @Column(name = "ADD_LINE2")
    private String addLine2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ZIP")
    private String zip;
}
