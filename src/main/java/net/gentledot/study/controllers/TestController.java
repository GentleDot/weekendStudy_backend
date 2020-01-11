package net.gentledot.study.controllers;

import net.gentledot.study.models.Test;
import net.gentledot.study.services.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tests")
@RestController
public class TestController {


    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<Test> search(@RequestParam String query){
        return testService.search(query);
    }

    @PostMapping
    public Test register(Test test){
        return testService.register(test);
    }

}
