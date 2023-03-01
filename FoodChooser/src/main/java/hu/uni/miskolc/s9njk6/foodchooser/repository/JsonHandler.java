package hu.uni.miskolc.s9njk6.foodchooser.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class JsonHandler {
    private final String path;
    private  final String dbJsonName;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //answers construktor
    public JsonHandler(String town, String cuisine) {
        path="src/main/resources/"+town.toLowerCase()+"_"+cuisine.toLowerCase()+"_answers.json";
        dbJsonName="answers";

    }

    //questions construktor
    public JsonHandler(String cuisine) {

        path = "src/main/resources/" + cuisine.toLowerCase() + "_questions.json";
        dbJsonName="questions";
    }

    public JsonHandler(Path pathEnum) {
        switch (pathEnum){
            case USERS:{
                path="src/main/resources/users.json";
                dbJsonName="users";}
            break;
            case RECOMMENDATIONS:{
                path="src/main/resources/customer_recommendations.json";
                dbJsonName="recommendations";
            }
            break;
            case CITIES:{
                path="src/main/resources/cities.json";
                dbJsonName="cities";
            }
            break;
            default:{
                path="";
                dbJsonName="";
            }
        }
    }

    //returns the content of the file as a JsonArray
    public JSONArray arrayParser(){

        JSONParser parser = new JSONParser();
        JSONArray array=new JSONArray();


        try {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;

            array = (JSONArray) jsonObject.get(dbJsonName);
        } catch (
                IOException | ParseException e) {
            e.printStackTrace();
        }
        return array;

    }
    //writes to the file from a JsonArray
    public void writeJsonArrayToFile(JSONArray entityAsJsonArray){

        JSONObject completeContent=new JSONObject();
        completeContent.put(dbJsonName,entityAsJsonArray);

        try (FileWriter file=new FileWriter(path)){
            file.write(gson.toJson(completeContent));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
