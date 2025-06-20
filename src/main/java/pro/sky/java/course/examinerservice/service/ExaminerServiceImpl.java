package pro.sky.java.course.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > service.getAll().size()) {
            throw new RuntimeException("Запрошено больше вопросов, чем есть в сервисе");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(service.getRandomQuestion());
        }
        return result;
    }
}
