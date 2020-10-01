package com.matheus.teles.beforeitstoolate.task

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
class CreateTaskIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    @Transactional
    fun `upon calling POST with valid data on tasks, should return 204`() {
        val task = TaskCreationSchema(
            title = "teste",
            description = "teste"
        )

        mockMvc.perform(post("/tasks")
            .content(objectMapper.writeValueAsString(task))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent)
    }

    @Test
    @Transactional
    fun `upon calling POST with invalid on tasks, should return 204`() {
        val task = TaskCreationSchema(
            title = null,
            description = "teste"
        )

        mockMvc.perform(post("/tasks")
            .content(objectMapper.writeValueAsString(task))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is4xxClientError)
    }
}