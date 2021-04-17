package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.EmployeeRequest;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EmployeePojoMapperTest extends TestCase {

    @Autowired
    EmployeePojoMapper employeePojoMapper;

    @Test
    public void testMapToPojo_WhenProperValuesPassed() {

        Optional<EmployeeRequest> employee = employeePojoMapper.mapToPojo(Optional.of(getEmpEntityWithAddress()));
        EmployeeRequest eq = EmployeeRequest.builder().id(5000).build();
        assertEquals(eq.getId(), employee.get().getId());
    }

    @Test(expected = NullPointerException.class)
    public void testMapToPojo_WhenNulllPassed() {

        Optional<EmployeeRequest> employee = employeePojoMapper.mapToPojo(null);
        EmployeeRequest eq = EmployeeRequest.builder().id(null).build();
        assertEquals(null, employee.get().getId());
    }

    @Test
    public void testMapToPojo_WhenEmptyPassed() {
        Optional<EmployeeRequest> employee = employeePojoMapper.mapToPojo(Optional.empty());
        Optional<Object> eq = Optional.empty();
        assertEquals(eq, employee.isPresent() ? employee.get().getId() : Optional.empty());
    }

}