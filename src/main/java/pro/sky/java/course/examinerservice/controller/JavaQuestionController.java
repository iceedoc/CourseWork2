package pro.sky.java.course.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course.examinerservice.domain.Question;
import pro.sky.java.course.examinerservice.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }
    @DeleteMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question unnecessaryQuestion = new Question(question, answer);
        return service.remove(unnecessaryQuestion);
    }
    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }
}



