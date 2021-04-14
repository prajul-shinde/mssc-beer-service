package com.csi.msscbeerservice.web.controller;

import com.csi.msscbeerservice.web.model.BeerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        //empty object
        BeerDto beerDto= BeerDto.builder().build();
        //object to json
        String beerToJson=objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto= BeerDto.builder().build();
        String beerToJson=objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isNoContent());
    }
}