package pro.sky.java.course.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course.examinerservice.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerServiceTest;
    private JavaQuestionService questionServiceTest;

    @BeforeEach
    public void setUp() {
        questionServiceTest = new JavaQuestionService();
        questionServiceTest.add("Question1", "Answer1");
        questionServiceTest.add("Question2", "Answer2");
        questionServiceTest.add("Question3", "Answer3");
        examinerServiceTest = new ExaminerServiceImpl(questionServiceTest);
    }

    @Test
    public void testGetQuestions() {
        int amount = 2;
        Collection<Question> questions = examinerServiceTest.getQuestions(amount);
        assertEquals(2, questions.size());
    }

    public void testQuestionsMoreThanPerhaps() {
        int amount = 10;
        try {
            examinerServiceTest.getQuestions(amount);
            fail("Ожидаемое исключение ResponseStatusException");
        } catch (ResponseStatusException e) {
            HttpStatusCode statusCode = e.getStatusCode();
            assertEquals(HttpStatus.BAD_REQUEST, statusCode);
        }
    }
}
