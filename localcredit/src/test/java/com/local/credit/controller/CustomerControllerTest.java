package com.local.credit.controller;

import com.local.credit.entities.Customer;
import com.local.credit.service.CustomerServiceImpl;
import com.local.credit.service.DataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerServiceImpl customerService;

    @InjectMocks
    private CostumerController customerController;

    //private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void findAllTest() throws Exception {
        List<Customer> mockCustomers = List.of(DataProvider.customerMock());
        when(customerService.findAll()).thenReturn(mockCustomers);

        mockMvc.perform(get("/api/local/credit/customer/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("David Orlando uno"))
                .andExpect(jsonPath("$[0].address").value("Vistas del lago"));
    }

    /*
    @Test
    void findAllTest() throws Exception {
        List<Customer> customers = List.of(
                new Customer(1L, "John Doe", "123 Street", "123456789", "john@example.com", "VIP"),
                new Customer(2L, "Jane Doe", "456 Avenue", "987654321", "jane@example.com", "Regular")
        );
        when(customerService.findAll()).thenReturn(customers);

        mockMvc.perform(get("/api/local/credit/customer/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].email").value("jane@example.com"));
    }

    @Test
    void findByIdTest_Found() throws Exception {
        Customer customer = new Customer(1L, "John Doe", "123 Street", "123456789", "john@example.com", "VIP");
        when(customerService.findById(1L)).thenReturn(Optional.of(customer));

        mockMvc.perform(get("/api/local/credit/customer/findById/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    void findByIdTest_NotFound() throws Exception {
        when(customerService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/local/credit/customer/findById/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void saveTest_Success() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "New Customer", "789 Road", "1122334455", "new@example.com", "New VIP");

        mockMvc.perform(post("/api/local/credit/customer/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void saveTest_BadRequest() throws Exception {
        CustomerDto customerDto = new CustomerDto(1L, "", "789 Road", "1122334455", "new@example.com", "New VIP");

        mockMvc.perform(post("/api/local/credit/customer/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteTest_Success() throws Exception {
        when(customerService.findById(1L)).thenReturn(Optional.of(new Customer()));

        mockMvc.perform(delete("/api/local/credit/customer/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Elemento eliminado como suceso"));
    }

    @Test
    void deleteTest_BadRequest() throws Exception {
        when(customerService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/local/credit/customer/delete/1"))
                .andExpect(status().isBadRequest());
    }*/
}
