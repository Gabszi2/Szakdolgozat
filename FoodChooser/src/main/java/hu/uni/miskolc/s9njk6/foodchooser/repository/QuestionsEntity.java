package hu.uni.miskolc.s9njk6.foodchooser.repository;


import java.util.Arrays;

public class QuestionsEntity {
    private String[] questions; //TODO csak 1 question


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

    @Override
    public String toString() {
        return "QuestionsEntity{" +
                "questions=" + Arrays.toString(questions) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionsEntity that = (QuestionsEntity) o;
        return Arrays.equals(questions, that.questions);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(questions);
    }
}
