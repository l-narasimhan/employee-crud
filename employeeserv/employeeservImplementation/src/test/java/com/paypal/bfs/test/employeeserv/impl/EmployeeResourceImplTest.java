package com.paypal.bfs.test.employeeserv.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.MediaType;

import static com.paypal.bfs.test.employeeserv.MockData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Import(EmployeeResourceImpl.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeResourceImplTest extends TestCase {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    @Qualifier("employeeService")
    EmployeeService employeeService;

    @Test
    public void testGetEmployeeById_shouldReturnResult_whenValidRequestParamsPassed() throws Exception {
        when(employeeService.getEmployeeById(any())).thenReturn(getEmployee());
        mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/bfs/employees/1001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1001))
                .andDo(print());

        verify(employeeService).getEmployeeById(any());
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    public void testGetEmployeeById_shouldReturnStatusNotFound_whenEmployeeIDsNotFound() throws Exception {
        when(employeeService.getEmployeeById(any())).thenReturn(Optional.empty());
        mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/bfs/employees/1001"))
                .andExpect(status().isNotFound());

        verify(employeeService).getEmployeeById(any());
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    public void testGetEmployeeById_shouldReturnException_whenSomethingGoesWrog() throws Exception {
        when(employeeService.getEmployeeById(any())).thenThrow(new InternalServerErrorException());
        mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/bfs/employees/1001"))
                .andExpect(status().isInternalServerError());

        verify(employeeService).getEmployeeById(any());
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    public void testCreateEmployee_shouldCreateRecord_whenValidRequestParamsPassed() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getEmployeeJson());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReeturnConflict_ifAlreadyPresent() throws Exception {
        when(employeeService.getEmployeeById(any())).thenReturn(getEmployee());

        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getEmployeeJson());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isConflict())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestParamsPassed() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidEmpId());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestFirstName() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidFirstName());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestFirstName_Null() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidFirstNameNull());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestlLastName() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidLastName());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestlDob() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidDob());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestlAddressLine1_Empty() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidAddline1());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestlCity_Empty() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidCity());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestCountry_Empty() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidCountry());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }

    @Test
    public void testCreateEmployee_shouldReturnBadRequest_whenInValidRequestlState_Empty() throws Exception {
        when(employeeService.createEmployee(any())).thenReturn(getEmployeeResponse());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getInvalidState());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andDo(print());

    }


    @Test
    public void testCreateEmployee_shouldThrowExcpetion_ifSomethingGoesWrong() throws Exception {
        when(employeeService.getEmployeeById(any())).thenReturn(Optional.empty());
        when(employeeService.createEmployee(any())).thenThrow(new InternalServerErrorException());
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(getEmployeeJson());
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/v1/bfs/createemployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isInternalServerError())
                .andDo(print());


    }

}
