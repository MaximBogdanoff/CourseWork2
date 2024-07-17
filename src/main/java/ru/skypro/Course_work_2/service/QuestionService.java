package ru.skypro.Course_work_2.service;

import ru.skypro.Course_work_2.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> findAll();
    Question findAllRandomQuestion();
}
