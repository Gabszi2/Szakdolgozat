package hu.uni.miskolc.s9njk6.foodchooser.repository;



import java.util.Objects;

public class QuestionEntity {
    private String question;


    public QuestionEntity(String question) {
        this.question = question;
    }

    public QuestionEntity() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question);
    }

    @Override
    public String toString() {
        return "QuestionsEntity{" +
                "question='" + question + '\'' +
                '}';
    }
}
