package com.bfhl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BfhlTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void exampleA() throws Exception {
        String body = "{\"data\":[\"a\",\"1\",\"334\",\"4\",\"R\",\"$\"]}";
        mvc.perform(post("/bfhl").contentType(MediaType.APPLICATION_JSON).content(body))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.is_success").value(true))
            .andExpect(jsonPath("$.sum").value("339"))
            .andExpect(jsonPath("$.concat_string").value("Ra"))
            .andExpect(jsonPath("$.odd_numbers[0]").value("1"))
            .andExpect(jsonPath("$.even_numbers[0]").value("334"))
            .andExpect(jsonPath("$.alphabets[0]").value("A"))
            .andExpect(jsonPath("$.special_characters[0]").value("$"));
    }

    @Test
    void exampleB() throws Exception {
        String body = "{\"data\":[\"2\",\"a\",\"y\",\"4\",\"&\",\"-\",\"*\",\"5\",\"92\",\"b\"]}";
        mvc.perform(post("/bfhl").contentType(MediaType.APPLICATION_JSON).content(body))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.sum").value("103"))
            .andExpect(jsonPath("$.concat_string").value("ByA"));
    }

    @Test
    void exampleC() throws Exception {
        String body = "{\"data\":[\"A\",\"ABCD\",\"DOE\"]}";
        mvc.perform(post("/bfhl").contentType(MediaType.APPLICATION_JSON).content(body))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.sum").value("0"))
            .andExpect(jsonPath("$.concat_string").value("EoDdCbAa"));
    }

    @Test
    void userIdFormat() throws Exception {
        String body = "{\"data\":[]}";
        mvc.perform(post("/bfhl").contentType(MediaType.APPLICATION_JSON).content(body))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user_id").value("shubhda_agrawal_29112005"))
            .andExpect(jsonPath("$.email").value("shubhdaagrawal230366@acropolis.in"))
            .andExpect(jsonPath("$.roll_number").value("0827cy231068"));
    }
}
