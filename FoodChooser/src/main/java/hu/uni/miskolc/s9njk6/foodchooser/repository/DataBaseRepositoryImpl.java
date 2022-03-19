package hu.uni.miskolc.s9njk6.foodchooser.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.*;


//Iterator-nál hiba lehet majd a <JsonObject>
@Component
public class DataBaseRepositoryImpl implements DataBaseRepository {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public FoodEntity saveFoodToTownAndKitchen(FoodEntity foodEntity, String town, String kitchen) {
        Collection<FoodEntity> inAll= getAllFoodFromTownAndKitchen(town,kitchen);
        JSONArray outToWrite=new JSONArray();
        int counter=0;

            for (FoodEntity entity:inAll
                 ) {
                //update
                if (!entity.getFoodName().equals(foodEntity.getFoodName())){

                    outToWrite.add(entity);
                    counter++;
                }else {

                    outToWrite.add(foodEntity);
                }


            }
            //create
            if (counter==inAll.size()){


                outToWrite.add(foodEntity);
            }

        new JsonHandler(town,kitchen).writeJsonArrayToFile(outToWrite);

        return foodEntity;

    }

    /**

     * @param oldQuestion question you want to change (for adding new question this should be the same as the newQuestion)
     * @param newQuestion question you want to change the old one (for adding new question this should be the same as the oldQuestion, this will be added)
     * @param kitchen
     */
    @Override
    public QuestionEntity saveQuestionsToKitchen(QuestionEntity oldQuestion, QuestionEntity newQuestion, String kitchen) {
        Collection<QuestionEntity> inAll=getAllQuestionFromKitchen(kitchen);
        JSONArray outToWrite=new JSONArray();
        int counter=0;

        for (QuestionEntity entity: inAll
             ) {

            if(!entity.getQuestion().equals(oldQuestion.getQuestion())){

                outToWrite.add(entity);
                counter++;
            }else {

                outToWrite.add(newQuestion);
            }


        }

        if (counter==inAll.size()){

            outToWrite.add(newQuestion);
        }
        new JsonHandler(kitchen).writeJsonArrayToFile(outToWrite);
        return newQuestion;

    }

    @Override
    public void deleteFoodFromTownAndKitchen(FoodEntity foodEntity, String town, String kitchen) {
        Collection<FoodEntity> inAll= getAllFoodFromTownAndKitchen(town,kitchen);
        JSONArray outToWrite=new JSONArray();

        for (FoodEntity entity:inAll
        ) {
            if (!entity.getFoodName().equals(foodEntity.getFoodName())){
                outToWrite.add(entity);
            }


        }
        new JsonHandler(town,kitchen).writeJsonArrayToFile(outToWrite);


    }

    @Override
    public void deleteQuestionFromKitchen(QuestionEntity question, String kitchen) {
        Collection<QuestionEntity> inAll=getAllQuestionFromKitchen(kitchen);
        JSONArray outToWrite=new JSONArray();

        for (QuestionEntity entity: inAll
        ) {
            if(!entity.getQuestion().equals(question.getQuestion())){
                outToWrite.add(entity);
            }

        }
        new JsonHandler(kitchen).writeJsonArrayToFile(outToWrite);
    }

    @Override
    public Collection<FoodEntity> getAllFoodFromTownAndKitchen(String town, String kitchen) {
        Collection<FoodEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(town, kitchen);
        JSONArray jsonArray=jsonHandler.arrayParser();

        Iterator<JSONObject> i=jsonArray.iterator();
        while (i.hasNext()){

            JSONObject answerJsonEntity=i.next();
            FoodEntity foodEntity =gson.fromJson(answerJsonEntity.toString(), FoodEntity.class);
            output.add(foodEntity);

        }

        return output;
    }

    @Override
    public Collection<QuestionEntity> getAllQuestionFromKitchen(String kitchen) {
        Collection<QuestionEntity> output=new ArrayList<>();

        JsonHandler jsonHandler=new JsonHandler(kitchen);
        JSONArray jsonArray=jsonHandler.arrayParser();

        Iterator<JSONObject> i= jsonArray.iterator();
        while (i.hasNext()){
            JSONObject question=i.next();
            QuestionEntity questionEntity=gson.fromJson(question.toString(),QuestionEntity.class);
            output.add(questionEntity);
        }


        return output;
    }

    @Override
    public FoodEntity getFoodFromTownAndKitchen(String foodName, String town, String kitchen) {
        Collection<FoodEntity> allFood=getAllFoodFromTownAndKitchen(town,kitchen);

        for (FoodEntity foodEntity:allFood
             ) {
            if (foodEntity.getFoodName().equals(foodName)){
                return foodEntity;
            }
        }
        return null;
    }

    @Override
    public QuestionEntity getQuestionFromKitchen(String question, String kitchen) {
        Collection<QuestionEntity> allQuestion=getAllQuestionFromKitchen(kitchen);

        for (QuestionEntity questionEntity:allQuestion
             ) {
            if (questionEntity.getQuestion().equals(question)){
                return questionEntity;
            }
        }
        return null;
    }
}
