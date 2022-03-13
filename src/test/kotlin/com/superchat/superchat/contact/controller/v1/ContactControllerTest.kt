package com.superchat.superchat.contact.controller.v1

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class ContactControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `GIVEN contact information WHEN POST api_v1_contacts THEN status is 201`() {
        mvc.perform(
            MockMvcRequestBuilders.post("/api/v1/contacts")
                .content(
                    objectMapper.writeValueAsBytes(
                        CreateContactRequest(
                            name = "Name Test",
                            email = "email@email.com"
                        )
                    )
                )
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(
                MockMvcResultMatchers.content()
                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
            )
    }

    @Test
    fun `GIVEN nothing WHEN POST api_v1_contacts THEN status is 201`() {
        mvc.perform(
            MockMvcRequestBuilders.post("/api/v1/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun `GIVEN nothing WHEN GET api_v1_contacts THEN retrieve all contacts`() {
        mvc.perform(
            MockMvcRequestBuilders.get("/api/v1/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content()
                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
            )
    }

}