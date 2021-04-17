package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.mapper.EmployeePojoMapper;
import com.paypal.bfs.test.employeeserv.model.EmployeeResponse;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.paypal.bfs.test.employeeserv.MockData.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeServiceTest extends TestCase {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @Mock
    private EmployeePojoMapper employeePojoMapper;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void getEmployeeById_returnsEmployeeRecord_WhenProperValuesPassed() {

        when(employeeRepository.findById(any())).thenReturn(Optional.of(getEmpEntity()));
        when(employeePojoMapper.mapToPojo(any())).thenReturn(getEmployee());

        Optional<EmployeeRequest> employee = employeeService.getEmployeeById(5000);

        assertEquals("firstname", employee.get().getFirstName());
        assertEquals("lastname", employee.get().getLastName());

    }

    @Test
    public void getEmployeeById_returnsEmpty_WhenNotPresent() {

        when(employeeRepository.findById(any())).thenReturn(Optional.empty());
        when(employeePojoMapper.mapToPojo(any())).thenReturn(Optional.empty());

        Optional<EmployeeRequest> employee = employeeService.getEmployeeById(5000);

        assertEquals(Optional.empty(), employee);

    }

    @Test(expected = NullPointerException.class)
    public void getEmployeeById_returnsNull_WhenNotPresent() {
        when(employeeRepository.findById(any())).thenReturn(null);
        when(employeePojoMapper.mapToPojo(any())).thenReturn(Optional.empty());

        Optional<EmployeeRequest> employee = employeeService.getEmployeeById(5000);

        assertEquals(Optional.empty(), employee);
    }

    @Test
    public void createEmployee_returnsEmployeeRecordId_WhenProperValuesPassed() {

        //when(employeeRepository.save(any())).thenReturn(any());
        when(employeeMapper.mapToEntity(any())).thenReturn(getEmpEntity());

        EmployeeResponse employee = employeeService.createEmployee(getEmployeeJson());

        assertEquals("1001", employee.getEmployeeId());
    }
}