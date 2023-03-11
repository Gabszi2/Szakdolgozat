package hu.uni.miskolc.s9njk6.foodchooser.repository;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document("Questions")
public class QuestionEntity {
    @Id
    private String id;
    private String question;
    private String cuisine;


    public QuestionEntity(String question,String cuisine) {

        this.question = question;
        this.cuisine=cuisine;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", cuisine='" + cuisine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(cuisine, that.cuisine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, cuisine);
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuestionEntity() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
