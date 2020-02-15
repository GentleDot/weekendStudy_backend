package net.gentledot.search.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class TestTestModel {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @DisplayName("Test 객체 생성 test")
    void createTestModelTest(){
        TestModel test = new TestModel.TestModelBuilder()
                .testNo(1L)
                .rawData(Map.of("kr", "안녕하세요."))
                .keyword("ㅇㄴㅎㅅㅇ")
                .updateAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();

        assertThat(test, is(notNullValue()));
        logger.info("생성된 test : {}", test.toString());
    }

}