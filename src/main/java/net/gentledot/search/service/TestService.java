package net.gentledot.search.service;

import net.gentledot.search.models.TestModel;

import java.util.List;

public interface TestService {
    List<TestModel> search(String keyword);
    TestModel register(TestModel testModel);
}
