package net.gentledot.search.service;

import net.gentledot.search.models.LangLocale;
import net.gentledot.search.models.TestModel;
import net.gentledot.search.models.api.request.Keywords;
import net.gentledot.search.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.gentledot.search.utils.DataUtil.chosung;
import static net.gentledot.search.utils.DataUtil.keyword;

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
        StringBuilder keywordStr = new StringBuilder();

        Map<String, String> rawDataMap = keywords.getRawData().entrySet()
                .stream().collect(Collectors.toMap(rawData -> rawData.getKey().locale(), Map.Entry::getValue));

        keywords.getRawData().forEach((locale, value) -> {
            if (locale.equals(LangLocale.kr)) {
                keywordStr.append(chosung(value))
                        .append(" ")
                        .append(keyword(value));
            } else {
                keywordStr.append(" ").append(keyword(value));
            }
        });

        return testRepository.saveAndFlush(new TestModel(rawDataMap, keywordStr.toString()));
    }
}
