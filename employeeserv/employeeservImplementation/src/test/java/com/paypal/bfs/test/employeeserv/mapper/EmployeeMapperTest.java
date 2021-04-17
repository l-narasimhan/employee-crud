package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.paypal.bfs.test.employeeserv.MockData.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void testMapToPojo_WhenProperValuesPassed() {

        EmployeeEntity employee = employeeMapper.mapToEntity(getEmployee1());
        EmployeeRequest eq = EmployeeRequest.builder().id(1001).build();
        assertEquals(eq.getId(), employee.getEmployeeId());
    }
}
