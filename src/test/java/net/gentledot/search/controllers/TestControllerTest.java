package net.gentledot.search.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.gentledot.search.models.Langs;
import net.gentledot.search.models.TestModel;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Constraint;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MockMvc mockMvc;

    @Test
    void searchTest() throws Exception {
        ResultActions actions = mockMvc.perform(get("/tests")
            .param("query", "a"));

        actions.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    void registryTest() throws Exception {
        String kr = "안녕, 자바!";
        String en = "Hello, Java!";
        Langs langs = new Langs(kr, en);
        TestModel test = new TestModel(null, langs, "인삿말", null, null);
        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions actions = mockMvc.perform(post("/tests")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(test)));

        MvcResult mvcResult = actions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("rawData.kr").value(kr))
                .andExpect(jsonPath("rawData.en").value(en))
                .andReturn();

        logger.info("Response Body : {}", mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
        assertThat(mvcResult.getResponse().getContentAsString(), notNullValue());
    }
}