package org.skypro.examinerservice.service;

import org.skypro.examinerservice.model.Question;

import java.util.Collection;
import java.util.List;

public interface ExaminerService {


    Collection<Question> getQuestions();
    List<Question> getQuestions(int amount);
}
