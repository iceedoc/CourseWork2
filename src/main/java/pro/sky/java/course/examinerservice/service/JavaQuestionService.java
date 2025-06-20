
package pro.sky.java.course.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final Collection<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question remove(String question, String answer) {
        Question q = new Question(question, answer);
        if (questions.remove(q)) {
            return q;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) return null;
        int index = new Random().nextInt(questions.size());
        return (Question) questions.toArray()[index];
    }
}
