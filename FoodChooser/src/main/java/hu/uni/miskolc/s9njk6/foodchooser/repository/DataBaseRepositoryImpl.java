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
    public RecommendationEntity saveRecommendation(RecommendationEntity recommendationEntity) {
        JSONArray outToWrite=new JSONArray();
        if (recommendationEntity.getId()==null){
            outToWrite=new JsonHandler(false).arrayParser();

            Long rndId;
            do{
                rndId=1 + (long) (Math.random() * (1000000 - 1));

            }while (getRecommendation(rndId)!=null);
            recommendationEntity.setId(rndId);

            outToWrite.add(recommendationEntity);

        }else {
            Collection<RecommendationEntity> inAll=getAllRecommendations(false);


            for (RecommendationEntity recommendation:inAll){
                //update
                if (recommendation.getId()!=recommendationEntity.getId()){
                    outToWrite.add(recommendation);

                }else {
                    outToWrite.add(recommendationEntity);
                }
            }
        }
        new  JsonHandler(false).writeJsonArrayToFile(outToWrite);
        return recommendationEntity;

    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        Collection<UserEntity> inAll=getAllUser();
        JSONArray outToWrite=new JSONArray();
        int counter=0;

        for (UserEntity user:inAll){
            //update
            if (!user.getEmail().equals(userEntity.getEmail())){
                outToWrite.add(user);
                counter++;
            }else {
                outToWrite.add(userEntity);
            }
        }
        //create
        if (counter==inAll.size()){
            outToWrite.add(userEntity);
        }
        new JsonHandler(true).writeJsonArrayToFile(outToWrite);
        return userEntity;
    }

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
    public void deleteRecommendation(RecommendationEntity recommendationEntity) {
        Collection<RecommendationEntity> inAll=getAllRecommendations(false);
        JSONArray outToWrite=new JSONArray();

        for (RecommendationEntity recommendation:inAll){
            if (recommendation.getId()!=recommendationEntity.getId()){
                outToWrite.add(recommendation);
            }
        }
        new JsonHandler(false).writeJsonArrayToFile(outToWrite);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        Collection<UserEntity> inAll= getAllUser();
        JSONArray outToWrite=new JSONArray();

        for (UserEntity user:inAll
        ) {
            if (!user.getEmail().equals(userEntity.getEmail())){
                outToWrite.add(user);
            }


        }
        new JsonHandler(true).writeJsonArrayToFile(outToWrite);
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
    /**

     * @param approved false=all recommendations, true=only approved recommendations


     */
    @Override
    public Collection<RecommendationEntity> getAllRecommendations(boolean approved) {
        Collection<RecommendationEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(false);
        JSONArray jsonArray=jsonHandler.arrayParser();

        Iterator<JSONObject>i= jsonArray.iterator();
        if (approved){
            while (i.hasNext()){
                JSONObject recommendationJsonEntity=i.next();
                RecommendationEntity recommendationEntity=gson.fromJson(recommendationJsonEntity.toString(),RecommendationEntity.class);
                if (recommendationEntity.isApproved()){
                    output.add(recommendationEntity);
                }
            }
        }else {
            while (i.hasNext()){
                JSONObject recommendationJsonEntity=i.next();
                RecommendationEntity recommendationEntity=gson.fromJson(recommendationJsonEntity.toString(),RecommendationEntity.class);
                output.add(recommendationEntity);
            }
        }
        return output;
    }

    @Override
    public Collection<UserEntity> getAllUser() {
        Collection<UserEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(true);
        JSONArray jsonArray=jsonHandler.arrayParser();

        Iterator<JSONObject> i=jsonArray.iterator();
        while (i.hasNext()){

            JSONObject userJsonEntity=i.next();
            UserEntity userEntity =gson.fromJson(userJsonEntity.toString(), UserEntity.class);
            output.add(userEntity);

        }

        return output;
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
    public RecommendationEntity getRecommendation(Long id) {
        Collection<RecommendationEntity> allRecommendation=getAllRecommendations(false);
        for (RecommendationEntity recommendation:allRecommendation){
            if (recommendation.getId()==id){
                return recommendation;
            }
        }
        return null;
    }

    @Override
    public UserEntity getUser(String email,String pasword) {
        Collection<UserEntity> allUser=getAllUser();

        for (UserEntity user:allUser
        ) {
            if (user.getEmail().equals(email)&&user.getPassword().equals(pasword)){
                return user;
            }
        }
        return null;
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
