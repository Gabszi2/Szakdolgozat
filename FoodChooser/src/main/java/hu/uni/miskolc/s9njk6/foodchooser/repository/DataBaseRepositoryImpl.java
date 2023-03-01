package hu.uni.miskolc.s9njk6.foodchooser.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.*;

//TODO Mongodb-be átalakítani
//Iterator-nál hiba lehet majd a <JsonObject>
@Component
public class DataBaseRepositoryImpl implements DataBaseRepository {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public CityEntity saveCity(CityEntity cityEntity) {
        Collection<CityEntity> inAll=getAllCities();
        JSONArray outToWrite=new JSONArray();
        int counter=0;

        for (CityEntity city:inAll){
            //update
            if (!city.getName().equals(cityEntity.getName())){
                outToWrite.add(city);
                counter++;
            }else {
                outToWrite.add(cityEntity);
            }

        }
        //create
        if (counter==inAll.size()){
            outToWrite.add(cityEntity);
        }
        new JsonHandler(Path.CITIES).writeJsonArrayToFile(outToWrite);
        return cityEntity;
    }

    @Override
    public RecommendationEntity saveRecommendation(RecommendationEntity recommendationEntity) {
        JSONArray outToWrite=new JSONArray();
        //create
        if (recommendationEntity.getId()==null){
            outToWrite=new JsonHandler(Path.RECOMMENDATIONS).arrayParser();

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
                if (!recommendation.getId().equals(recommendationEntity.getId())){
                    outToWrite.add(recommendation);

                }else {
                    outToWrite.add(recommendationEntity);
                }
            }
        }
        new  JsonHandler(Path.RECOMMENDATIONS).writeJsonArrayToFile(outToWrite);
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
        new JsonHandler(Path.USERS).writeJsonArrayToFile(outToWrite);
        return userEntity;
    }

    @Override
    public FoodEntity saveFoodToTownAndCuisine(FoodEntity foodEntity, String town, String cuisine) {
        Collection<FoodEntity> inAll= getAllFoodFromTownAndCuisine(town,cuisine);
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

        new JsonHandler(town,cuisine).writeJsonArrayToFile(outToWrite);

        return foodEntity;

    }

    /**

     * @param oldQuestion question you want to change (for adding new question this should be the same as the newQuestion)
     * @param newQuestion question you want to change the old one (for adding new question this should be the same as the oldQuestion, this will be added)

     */
    @Override
    public QuestionEntity saveQuestionsToCuisine(QuestionEntity oldQuestion, QuestionEntity newQuestion, String cuisine) {
        Collection<QuestionEntity> inAll=getAllQuestionFromCuisine(cuisine);
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
        new JsonHandler(cuisine).writeJsonArrayToFile(outToWrite);
        return newQuestion;

    }

    @Override
    public void deleteCity(String name) {
        Collection<CityEntity> inAll=getAllCities();
        JSONArray outToWrite=new JSONArray();
        for (CityEntity city:inAll
             ) {
            if (!city.getName().equals(name)){
                outToWrite.add(city);
            }

        }
        new JsonHandler(Path.CITIES).writeJsonArrayToFile(outToWrite);

    }

    @Override
    public void deleteRecommendation(Long id) {
        Collection<RecommendationEntity> inAll=getAllRecommendations(false);
        JSONArray outToWrite=new JSONArray();

        for (RecommendationEntity recommendation:inAll){
            if (!recommendation.getId().equals(id)){
                outToWrite.add(recommendation);
            }
        }
        new JsonHandler(Path.RECOMMENDATIONS).writeJsonArrayToFile(outToWrite);
    }

    @Override
    public void deleteUser(String email) {
        Collection<UserEntity> inAll= getAllUser();
        JSONArray outToWrite=new JSONArray();

        for (UserEntity user:inAll
        ) {
            if (!user.getEmail().equals(email)){
                outToWrite.add(user);
            }


        }
        new JsonHandler(Path.USERS).writeJsonArrayToFile(outToWrite);
    }

    @Override
    public void deleteFoodFromTownAndCuisine(FoodEntity foodEntity, String town, String cuisine) {
        Collection<FoodEntity> inAll= getAllFoodFromTownAndCuisine(town,cuisine);
        JSONArray outToWrite=new JSONArray();

        for (FoodEntity entity:inAll
        ) {
            if (!entity.getFoodName().equals(foodEntity.getFoodName())){
                outToWrite.add(entity);
            }


        }
        new JsonHandler(town,cuisine).writeJsonArrayToFile(outToWrite);


    }

    @Override
    public void deleteQuestionFromCuisine(QuestionEntity question, String cuisine) {
        Collection<QuestionEntity> inAll=getAllQuestionFromCuisine(cuisine);
        JSONArray outToWrite=new JSONArray();

        for (QuestionEntity entity: inAll
        ) {
            if(!entity.getQuestion().equals(question.getQuestion())){
                outToWrite.add(entity);
            }

        }
        new JsonHandler(cuisine).writeJsonArrayToFile(outToWrite);
    }
    /**

     * @param approved false=all recommendations, true=only approved recommendations


     */
    @Override
    public Collection<RecommendationEntity> getAllRecommendations(boolean approved) {
        Collection<RecommendationEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(Path.RECOMMENDATIONS);
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
        JsonHandler jsonHandler=new JsonHandler(Path.USERS);
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
    public Collection<FoodEntity> getAllFoodFromTownAndCuisine(String town, String cuisine) {
        Collection<FoodEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(town, cuisine);
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
    public Collection<QuestionEntity> getAllQuestionFromCuisine(String cuisine) {
        Collection<QuestionEntity> output=new ArrayList<>();

        JsonHandler jsonHandler=new JsonHandler(cuisine);
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
    public Collection<CityEntity> getAllCities() {
        Collection<CityEntity> output=new ArrayList<>();
        JsonHandler jsonHandler=new JsonHandler(Path.CITIES);
        JSONArray jsonArray=jsonHandler.arrayParser();
        Iterator<JSONObject> i= jsonArray.iterator();
        while (i.hasNext()){
            JSONObject city=i.next();
            CityEntity cityEntity=gson.fromJson(city.toString(),CityEntity.class);
            output.add(cityEntity);
        }
        return output;
    }

    @Override
    public RecommendationEntity getRecommendation(Long id) {
        Collection<RecommendationEntity> allRecommendation=getAllRecommendations(false);
        for (RecommendationEntity recommendation:allRecommendation){
            if (recommendation.getId().equals(id)){
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
    public FoodEntity getFoodFromTownAndCuisine(String foodName, String town, String cuisine) {
        Collection<FoodEntity> allFood=getAllFoodFromTownAndCuisine(town,cuisine);

        for (FoodEntity foodEntity:allFood
             ) {
            if (foodEntity.getFoodName().equals(foodName)){
                return foodEntity;
            }
        }
        return null;
    }

    @Override
    public QuestionEntity getQuestionFromCuisine(String question, String cuisine) {
        Collection<QuestionEntity> allQuestion=getAllQuestionFromCuisine(cuisine);

        for (QuestionEntity questionEntity:allQuestion
             ) {
            if (questionEntity.getQuestion().equals(question)){
                return questionEntity;
            }
        }
        return null;
    }

    @Override
    public CityEntity getCity(String name) {
        Collection<CityEntity> allCities=getAllCities();
        for (CityEntity cityEntity:allCities
             ) {
            if (cityEntity.getName().equals(name)){
                return cityEntity;
            }

        }
        return null;
    }

}
