package hu.uni.miskolc.s9njk6.foodchooser.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


//Iterator-nál hiba lehet majd a <JsonObject>
@Component
public class DataBaseRepositoryImpl implements DataBaseRepository {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void saveFoodToTownAndKitchen(FoodEntity foodEntity, String town, String kitchen) {
        Collection<FoodEntity> inAll= getAllFoodFromTownAndKitchen(town,kitchen);
        JSONArray outToWrite=new JSONArray();
        int counter=0;

            for (FoodEntity entity:inAll
                 ) {

                if (!entity.getFoodName().equals(foodEntity.getFoodName())){

                    outToWrite.add(entity);
                    counter++;
                }else {

                    outToWrite.add(foodEntity);
                }


            }

            if (counter==inAll.size()){


                outToWrite.add(foodEntity);
            }

        new JsonHandler(town,kitchen).writeJsonArrayToFile(outToWrite);


    }

    /**

     * @param oldQuestion question you want to change (for adding new question this should be the same as the newQuestion, this will be added)
     * @param newQuestion question you want to change the old one (for adding new question this should be the same as the oldQuestion)
     * @param kitchen
     */
    @Override
    public void saveQuestionsToKitchen(QuestionEntity oldQuestion, QuestionEntity newQuestion, String kitchen) {
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
            newQuestion=oldQuestion;
            outToWrite.add(newQuestion);
        }
        new JsonHandler(kitchen).writeJsonArrayToFile(outToWrite);
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
        FoodEntity output=new FoodEntity();
        boolean found=false;
        JsonHandler jsonHandler=new JsonHandler(town, kitchen);
        JSONArray jsonArray=jsonHandler.arrayParser();
        Iterator<JSONObject> i= jsonArray.iterator();
        while (i.hasNext()||!found){
            JSONObject answer= i.next();
            FoodEntity check=gson.fromJson(answer.toString(), FoodEntity.class);
            if (check.getFoodName().equals(foodName)){
                found=true;
                output=check;
            }

        }

        return output;
    }
}
