package org.skypro.examinerservice.service;

import org.skypro.examinerservice.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);
    String add(String question);
    Question remove(String question, String answer);
    Question remove(String question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}

