package hu.uni.miskolc.s9njk6.foodchooser.controller;

import javax.validation.constraints.NotEmpty;

public class QuestionSaveDto {
    @NotEmpty
    private String oldQuestion;
    @NotEmpty
    private String newQuestion;

    public QuestionSaveDto() {
    }

    public QuestionSaveDto(String oldQuestion, String newQuestion) {
        this.oldQuestion = oldQuestion;
        this.newQuestion = newQuestion;
    }

    public String getOldQuestion() {
        return oldQuestion;
    }

    public void setOldQuestion(String oldQuestion) {
        this.oldQuestion = oldQuestion;
    }

    public String getNewQuestion() {
        return newQuestion;
    }

    public void setNewQuestion(String newQuestion) {
        this.newQuestion = newQuestion;
    }

    @Override
    public String toString() {
        return "QuestionSaveDto{" +
                "oldQuestion='" + oldQuestion + '\'' +
                ", newQuestion='" + newQuestion + '\'' +
                '}';
    }
}
