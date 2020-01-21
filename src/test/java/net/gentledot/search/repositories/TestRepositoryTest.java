package net.gentledot.search.repositories;

import net.gentledot.search.models.TestModel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TestRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TestRepository testRepository;

    @Test
    void getAllDataTest(){
        List<TestModel> allData = testRepository.findAll();

        logger.info(allData.toString());
    }

    @Test
    void getDataTest(){
        Optional<TestModel> one = testRepository.findById(1L);

        if (one.isEmpty()){
            logger.info(one.toString());
        }

        logger.info(one.toString());
    }

    @Test
    void getDataWithKeywordTest(){

        List<TestModel> test = testRepository.findAllByKeyword("test");

        logger.info("전달받은 list : {}", test);
    }
}