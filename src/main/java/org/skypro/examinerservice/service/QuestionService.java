package org.skypro.examinerservice.service;

import org.skypro.examinerservice.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);
    Question add(String question);
    Question remove(String question, String answer);
    Question remove(String question);
    Question find(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();
}

