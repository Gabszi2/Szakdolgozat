package hu.uni.miskolc.s9njk6.foodchooser.repository;


public class QuestionsEntity {
    private String[] questions;


    public QuestionsEntity(String[] questions) {
        this.questions = questions;
    }

    public QuestionsEntity() {
    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }


}
