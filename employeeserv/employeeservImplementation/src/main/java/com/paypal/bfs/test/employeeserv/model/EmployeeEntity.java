package com.paypal.bfs.test.employeeserv.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DOB")
    private String dob;

    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "employeeId")
    @JoinColumn(name = "Id",referencedColumnName = "Id")
    private AddressEntity address;
}
