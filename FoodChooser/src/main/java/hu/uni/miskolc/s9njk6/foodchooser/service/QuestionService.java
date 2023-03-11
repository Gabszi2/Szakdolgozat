package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;

public interface QuestionService {
    Iterable<String> allQuestions(String cuisine);

    void deleteQuestion(String question, String cuisine) throws NoSuchEntityException;

    String createQuestion(String question, String cuisine) throws EntityAlreadyExistsException;

    void saveQuestion(String oldQuestion, String newQuestion, String cuisine) throws NoSuchEntityException;
}
