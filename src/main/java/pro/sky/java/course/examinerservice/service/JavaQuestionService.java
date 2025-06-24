
package pro.sky.java.course.examinerservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course.examinerservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {

        for (Question q : questions) {
            if (q.getQuestion().equalsIgnoreCase(question)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Данный вопрос уже был добавлен ранее");
            }
        }
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        for (Question q : questions) {
            if (q.getQuestion().equalsIgnoreCase(question.getQuestion())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Данный вопрос уже был добавлен ранее");
            }
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()) {
            Question q = iterator.next();
            if (q.equals(question)) {
                iterator.remove();
                return q;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ошибка удаления");
    }



    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = new ArrayList<>(getAll());
        if (questions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Список вопросов пуст");
        }
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}