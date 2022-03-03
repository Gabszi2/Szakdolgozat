package hu.uni.miskolc.s9njk6.foodchooser.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



@Component
public class AdminRepositoryImpl implements AdminRepository {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void saveFoodToTownAndKitchen(AnswerEntity answerEntity, String town, String kitchen) {

    }

    @Override
    public void saveQuestionsToKitchen(String oldQuestion, String newQuestion, String kitchen) {

    }

    @Override
    public void addFoodToTownAndKitchen(AnswerEntity answerEntity, String town, String kitchen) {

    }

    @Override
    public void addQuestionsToKitchen(String question, String kitchen) {

    }

    @Override
    public void deleteFoodFromTownAndKitchen(AnswerEntity answerEntity, String town, String kitchen) {

    }

    @Override
    public void deleteQuestionFromKitchen(String question, String kitchen) {

    }

    @Override
    public Collection<AnswerEntity> findAllFoodFromTownAndKitchen(String town, String kitchen) {
        Collection<AnswerEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(town, kitchen);
        JSONArray jsonArray=jsonHandler.arrayParser();

        Iterator i=jsonArray.iterator();
        while (i.hasNext()){

            JSONObject answerJsonEntity=(JSONObject)i.next();
            AnswerEntity answerEntity=gson.fromJson(answerJsonEntity.toString(),AnswerEntity.class);
            output.add(answerEntity);

        }

        return output;
    }

    @Override
    public QuestionsEntity getAllQuestionsFromKitchen(String kitchen) {
        QuestionsEntity output=new QuestionsEntity();
        ArrayList<String> answers=new ArrayList<>();

        JsonHandler jsonHandler=new JsonHandler(kitchen);
        JSONArray jsonArray=jsonHandler.arrayParser();

        Iterator i=jsonArray.iterator();
        while (i.hasNext()){
            JSONObject question=(JSONObject) i.next();
            answers.add(gson.fromJson(question.toString(),String.class));
        }
        output.setQuestions(answers.toArray(new String[0]));
        return output;
    }

    @Override
    public AnswerEntity getFoodFromTownAndKitchen(String foodName, String town, String kitchen) {
        return null;
    }
}
