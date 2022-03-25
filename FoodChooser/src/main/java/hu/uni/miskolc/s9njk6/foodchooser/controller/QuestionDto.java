package hu.uni.miskolc.s9njk6.foodchooser.controller;

import javax.validation.constraints.NotEmpty;

public class QuestionDto {
    @NotEmpty
    private String question;

    public QuestionDto() {
    }

    public QuestionDto(String question) {
        this.question = question;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "question='" + question + '\'' +
                '}';
    }
}
