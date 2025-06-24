package pro.sky.java.course.examinerservice.service;

import pro.sky.java.course.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    Question add(Question question);
}
