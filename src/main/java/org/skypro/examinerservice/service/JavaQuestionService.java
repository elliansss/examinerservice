package org.skypro.examinerservice.service;

import org.skypro.examinerservice.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final String dataFilePath = "questions.json"; //пробовала реализовать, не получается, не понимаю
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public String add(String question) {
        return question;
    }

    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionToRemove = new Question(question, answer);
        if(questions.remove(questionToRemove)){
            return questionToRemove;
        }
        return null;
    }

    @Override
    public Question remove(String question) {
        return null;
    }

    public Question remove(Question question) {
        if(questions.remove(question)){
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.stream()
                .skip(randomIndex)
                .findFirst()
                .orElse(null);
    }
}