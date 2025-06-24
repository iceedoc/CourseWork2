package pro.sky.java.course.examinerservice.service;

import pro.sky.java.course.examinerservice.domain.Question;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

