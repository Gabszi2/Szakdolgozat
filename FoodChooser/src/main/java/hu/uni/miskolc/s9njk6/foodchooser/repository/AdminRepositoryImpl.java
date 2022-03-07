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
public class AdminRepositoryImpl implements AdminRepository {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String ANSWER ="answer";
    private static final String QUESTION ="question";

    @Override
    public void saveFoodToTownAndKitchen(AnswerEntity answerEntity, String town, String kitchen) {
        Collection<AnswerEntity> inAll= getAllFoodFromTownAndKitchen(town,kitchen);
        JSONArray outToWrite=new JSONArray();
        int counter=0;

            for (AnswerEntity entity:inAll
                 ) {
                JSONObject jsonObject=new JSONObject();
                if (!entity.getFoodName().equals(answerEntity.getFoodName())){
                    jsonObject.put(ANSWER,entity);
                }else {
                    jsonObject.put(ANSWER,answerEntity);
                }
                counter++;
                outToWrite.add(jsonObject);
            }
            if (counter!=inAll.size()){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put(ANSWER,answerEntity);
                outToWrite.add(jsonObject);
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
            JSONObject jsonObject=new JSONObject();
            if(!entity.getQuestion().equals(oldQuestion.getQuestion())){
                jsonObject.put(QUESTION,entity);
            }else {
                jsonObject.put(QUESTION, newQuestion);
            }
            counter++;
           outToWrite.add(jsonObject);
        }
        if (counter!=inAll.size()){
            newQuestion=oldQuestion;
            JSONObject jsonObject=new JSONObject();
            jsonObject.put(QUESTION,newQuestion);
            outToWrite.add(jsonObject);
        }
        new JsonHandler(kitchen).writeJsonArrayToFile(outToWrite);
    }

    @Override
    public void deleteFoodFromTownAndKitchen(AnswerEntity answerEntity, String town, String kitchen) {
        Collection<AnswerEntity> inAll= getAllFoodFromTownAndKitchen(town,kitchen);
        JSONArray outToWrite=new JSONArray();

        for (AnswerEntity entity:inAll
        ) {
            JSONObject jsonObject=new JSONObject();
            if (!entity.getFoodName().equals(answerEntity.getFoodName())){
                jsonObject.put(ANSWER,entity);
            }
            outToWrite.add(jsonObject);

        }
        new JsonHandler(town,kitchen).writeJsonArrayToFile(outToWrite);


    }

    @Override
    public void deleteQuestionFromKitchen(QuestionEntity question, String kitchen) {
        Collection<QuestionEntity> inAll=getAllQuestionFromKitchen(kitchen);
        JSONArray outToWrite=new JSONArray();

        for (QuestionEntity entity: inAll
        ) {
            JSONObject jsonObject=new JSONObject();
            if(!entity.getQuestion().equals(question.getQuestion())){
                jsonObject.put(QUESTION,entity);
            }
            outToWrite.add(jsonObject);
        }
        new JsonHandler(kitchen).writeJsonArrayToFile(outToWrite);
    }

    @Override
    public Collection<AnswerEntity> getAllFoodFromTownAndKitchen(String town, String kitchen) {
        Collection<AnswerEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(town, kitchen);
        JSONArray jsonArray=jsonHandler.arrayParser();

        Iterator<JSONObject> i=jsonArray.iterator();
        while (i.hasNext()){

            JSONObject answerJsonEntity=i.next();
            AnswerEntity answerEntity=gson.fromJson(answerJsonEntity.toString(),AnswerEntity.class);
            output.add(answerEntity);

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
    public AnswerEntity getFoodFromTownAndKitchen(String foodName, String town, String kitchen) {
        AnswerEntity output=new AnswerEntity();
        boolean found=false;
        JsonHandler jsonHandler=new JsonHandler(town, kitchen);
        JSONArray jsonArray=jsonHandler.arrayParser();
        Iterator<JSONObject> i= jsonArray.iterator();
        while (i.hasNext()||!found){
            JSONObject answer= i.next();
            AnswerEntity check=gson.fromJson(answer.toString(),AnswerEntity.class);
            if (check.getFoodName().equals(foodName)){
                found=true;
                output=check;
            }

        }

        return output;
    }
}
