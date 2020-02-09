package net.gentledot.search.service;

import net.gentledot.search.models.TestModel;
import net.gentledot.search.models.api.request.Keywords;
import net.gentledot.search.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestModel> search(String keyword) {
        return testRepository.findAllByKeyword(keyword);
    }

    public TestModel register(Keywords keywords) {
        TestModel testModel = new TestModel(keywords.getRawData(), keywords.getKeyword());
        return testRepository.save(testModel);
    }
}
