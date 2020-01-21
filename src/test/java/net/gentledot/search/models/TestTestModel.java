package net.gentledot.search.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class TestTestModel {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @DisplayName("Test 객체 생성 test")
    void createTestModelTest(){
        TestModel test = new TestModel(1L);
        TestModel anotherTest = TestModel.builder(new TestModel(2L))
                .rawData(new Langs("안녕하세요.", "Hello!"))
                .keyword("testKeyword")
                .updateAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();

        logger.info("생성된 test : {}", test.toString());
        logger.info("생성된 anotherTest : {}", anotherTest.toString());

        assertThat(test, is(notNullValue()));
        assertThat(anotherTest, is(notNullValue()));
    }

}