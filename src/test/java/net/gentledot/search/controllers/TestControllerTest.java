package net.gentledot.search.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.gentledot.search.models.LangLocale;
import net.gentledot.search.models.TestModel;
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

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
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
        String kr = "안녕";
        String en = "Hello";
        Map<LangLocale, String> request = new HashMap<>();
        request.put(LangLocale.kr, kr);
        request.put(LangLocale.en, en);

        Map<String, String> langsMap = request.entrySet().stream()
                .collect(Collectors.toMap(rawData -> rawData.getKey().locale(), Map.Entry::getValue));

        TestModel test = new TestModel(null, langsMap, "인삿말", null, null);
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