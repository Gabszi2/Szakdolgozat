package hu.uni.miskolc.s9njk6.foodchooser.repository;

import java.util.Arrays;
import java.util.Objects;

public class QuestionsEntity {
    private String[] questions;
    private String kitchen;

    public QuestionsEntity(String[] questions,String kitchen) {
        this.questions = questions;
        this.kitchen=kitchen;
    }

    public QuestionsEntity() {
    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionsEntity that = (QuestionsEntity) o;
        return Arrays.equals(questions, that.questions) && Objects.equals(kitchen, that.kitchen);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(kitchen);
        result = 31 * result + Arrays.hashCode(questions);
        return result;
    }
}
