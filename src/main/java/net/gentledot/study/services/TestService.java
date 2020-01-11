package net.gentledot.study.services;

import net.gentledot.study.models.Test;
import net.gentledot.study.repositories.TestRepository;
import net.gentledot.study.utils.DataUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;
    private final DataUtil dataUtil;

    public TestService(TestRepository testRepository, DataUtil dataUtil) {
        this.testRepository = testRepository;
        this.dataUtil = dataUtil;
    }

    public List<Test> search(String query) {
        return this.testRepository.search(dataUtil.keyword(query));
    }

    public Test register(Test test) {
        StringBuilder keyword = new StringBuilder();
        keyword.append(dataUtil.chosung(test.getRawData()))
                .append(" ")
                .append(dataUtil.keyword(test.getRawData()));
        test.setKeyword(keyword.toString());
        return this.testRepository.saveAndFlush(test);
    }
}