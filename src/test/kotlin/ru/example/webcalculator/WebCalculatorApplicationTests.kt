package ru.example.webcalculator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class WebCalculatorApplicationTests
{

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test addition endpoint`()
    {
        mockMvc.perform(get("/calculator/addition")
                .param("a", "5.6")
                .param("b", "3"))
                .andExpect(status().isOk)
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "Результат операции: 8.6"))
    }

    @Test
    fun `test subtraction endpoint`()
    {
        mockMvc.perform(get("/calculator/subtraction")
                .param("a", "10")
                .param("b", "3.7"))
                .andExpect(status().isOk)
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "Результат операции: 6.3"))
    }

    @Test
    fun `test multiplication endpoint`()
    {
        mockMvc.perform(get("/calculator/multiplication")
                .param("a", "4")
                .param("b", "2.2"))
                .andExpect(status().isOk)
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "Результат операции: 8.8"))
    }

    @Test
    fun `test division endpoint`()
    {
        mockMvc.perform(get("/calculator/division")
                .param("a", "8.5")
                .param("b", "2"))
                .andExpect(status().isOk)
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "Результат операции: 4.25"))
    }

    @Test
    fun `test division by zero`()
    {
        mockMvc.perform(get("/calculator/division")
                .param("a", "8")
                .param("b", "0"))
                .andExpect(status().isOk)
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "Результат операции: Infinity"))
    }
}
