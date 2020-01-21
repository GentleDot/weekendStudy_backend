package net.gentledot.search.service;

import net.gentledot.search.models.TestModel;
import net.gentledot.search.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<TestModel> search(String keyword) {
        return testRepository.findAllByKeyword(keyword);
    }

    @Override
    public TestModel register(TestModel testModel) {
        return testRepository.save(testModel);
    }
}
