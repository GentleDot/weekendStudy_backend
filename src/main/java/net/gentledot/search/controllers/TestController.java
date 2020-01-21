package net.gentledot.search.controllers;

import net.gentledot.search.models.TestModel;
import net.gentledot.search.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tests")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<TestModel> search(@RequestParam(name = "query") String query){
        return testService.search(query);
    }

    @PostMapping
    public TestModel registry(@RequestBody TestModel testModel){
        return testService.register(testModel);
    }
}
