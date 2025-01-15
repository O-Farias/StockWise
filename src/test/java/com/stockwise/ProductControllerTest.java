package com.stockwise;

import com.stockwise.model.Product;
import com.stockwise.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductService productService;

    @BeforeEach
    public void setup() {
        productService.findAll().forEach(product -> productService.deleteById(product.getId()));
    }

    @Test
    public void shouldReturnEmptyListWhenNoProductsExist() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andDo(print());
    }

    @Test
    public void shouldCreateNewProduct() throws Exception {
        String newProductJson = """
                {
                    "name": "Notebook",
                    "quantity": 10,
                    "price": 2500.00
                }
                """;

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newProductJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Notebook"))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.price").value(2500.00))
                .andDo(print());
    }

    @Test
    public void shouldReturnBadRequestWhenProductIsInvalid() throws Exception {
        // Tenta salvar um produto com dados inválidos
        String invalidProductJson = """
                {
                    "name": "",
                    "price": -10.0,
                    "quantity": -5
                }
                """;

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidProductJson))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void shouldReturnNotFoundWhenProductDoesNotExist() throws Exception {
        // Tenta buscar um produto inexistente
        mockMvc.perform(get("/products/999"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}
