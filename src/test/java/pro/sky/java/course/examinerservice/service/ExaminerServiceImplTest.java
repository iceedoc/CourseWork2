package pro.sky.java.course.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course.examinerservice.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


public class ExaminerServiceImplTest {
    private JavaQuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        questionService = new JavaQuestionService();
        questionService.add("Q1", "A1");
        questionService.add("Q2", "A2");
        questionService.add("Q3", "A3");
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void testGetQuestionsSuccess() {
        Collection<Question> questions = examinerService.getQuestions(2);
        assertEquals(2, questions.size());
    }

    @Test
    public void testGetQuestionsMoreThanAvailable() {
        String type = "java";
        int amount = 15;
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            examinerService.getQuestions(amount);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
}
