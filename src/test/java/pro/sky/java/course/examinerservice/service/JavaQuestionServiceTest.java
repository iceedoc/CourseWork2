package pro.sky.java.course.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course.examinerservice.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    void addTest() {
        Question q = service.add("Question1", "Answer1");
        assertNotNull(q);
        assertTrue(service.getAll().contains(q));
    }

    @Test
    void removeTest() {
        Question q = service.add("Question2", "Answer2");
        Question removed = service.remove("Question2", "Answer2");
        assertEquals(q, removed);
        assertFalse(service.getAll().contains(q));
    }

    @Test
    void getRandomQuestionTest() {
        service.add("Q1", "A1");
        service.add("Q2", "A2");
        Question random = service.getRandomQuestion();
        assertNotNull(random);
        assertTrue(service.getAll().contains(random));
    }

    @Test
    void getAllTest() {
        service.add("Q3", "A3");
        service.add("Q4", "A4");
        Collection<Question> all = service.getAll();
        assertEquals(2, all.size());
    }
}