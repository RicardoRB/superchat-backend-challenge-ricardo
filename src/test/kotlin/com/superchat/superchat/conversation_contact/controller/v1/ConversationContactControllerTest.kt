package com.superchat.superchat.conversation_contact.controller.v1

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*


@SpringBootTest
@AutoConfigureMockMvc
internal class ConversationContactControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun `GIVEN nothing WHEN GET api_v1_contacts_contactUUID_conversations THEN status 200`() {
        mvc.perform(
            MockMvcRequestBuilders.get("/api/v1/contacts/${UUID.randomUUID()}/conversations")
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