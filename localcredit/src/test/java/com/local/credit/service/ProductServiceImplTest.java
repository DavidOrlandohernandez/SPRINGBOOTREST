package com.local.credit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/api/local/credit/product/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))  // Verifica 2 registros
                .andExpect(jsonPath("$[0].name").value("Coca-Cola 600ml"));
    }

    /*
    @Test
    void findAllTest() throws Exception {
        mockMvc.perform(get("/api/local/credit/customer/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))  // Ajusta según la cantidad de registros en la BD
                .andExpect(jsonPath("$[0].name").value("John Doe")); // Verifica un cliente de prueba
    }

    @Test
    void findByIdTest_Found() throws Exception {
        mockMvc.perform(get("/api/local/credit/customer/findById/1")) // Suponiendo que existe un ID 1 en la BD
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void findByIdTest_NotFound() throws Exception {
        mockMvc.perform(get("/api/local/credit/customer/findById/9999")) // Un ID que no exista
                .andExpect(status().isNotFound());
    }

    @Test
    void saveTest_Success() throws Exception {
        String json = """
        {
            "name": "Nuevo Cliente",
            "address": "Calle 123",
            "phone": "123456789",
            "email": "nuevo@example.com",
            "description": "Cliente especial"
        }
        """;

        mockMvc.perform(post("/api/local/credit/customer/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void saveTest_BadRequest() throws Exception {
        String json = """
        {
            "name": "",
            "address": "Calle 123",
            "phone": "123456789",
            "email": "nuevo@example.com",
            "description": "Cliente especial"
        }
        """;

        mockMvc.perform(post("/api/local/credit/customer/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteTest_Success() throws Exception {
        mockMvc.perform(delete("/api/local/credit/customer/delete/1")) // Suponiendo que el ID 1 existe
                .andExpect(status().isOk())
                .andExpect(content().string("Elemento eliminado como suceso"));
    }

    @Test
    void deleteTest_BadRequest() throws Exception {
        mockMvc.perform(delete("/api/local/credit/customer/delete/9999")) // Un ID que no exista
                .andExpect(status().isBadRequest());
    }*/
}
