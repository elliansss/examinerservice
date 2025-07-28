package org.skypro.examinerservice.controller;

import org.skypro.examinerservice.model.Question;
import org.skypro.examinerservice.service.ExaminerService;
import org.skypro.examinerservice.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public JavaExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Количество вопросов не может быть меньше 0");
        }

        List<Question> allQuestions = new ArrayList<>(questionService.getAll());

        if (allQuestions.size() < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Больше вопросов нет");
        }

        Set<Question> selectedQuestions = new HashSet<>();
        Random random = new Random();
        while (selectedQuestions.size() < amount) {
            int randomIndex = random.nextInt(allQuestions.size());
            Question randomQuestion = allQuestions.get(randomIndex);
            selectedQuestions.add(randomQuestion);
        }
        return new ArrayList<>(selectedQuestions);
    }

    @Override
    public List<Question> getQuestions() {
        return questionService.getAll().stream().collect(Collectors.toList());
    }
}
