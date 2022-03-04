package hu.uni.miskolc.s9njk6.foodchooser.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonHandler {
    private String town;
    private String kitchen;
    private final String path;
    private  final String dbJsonName;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //answers construktor
    public JsonHandler(String town, String kitchen) {
        this.town = town;
        this.kitchen = kitchen;
        path="src/main/resources/"+town+"_"+kitchen+"_answers.json";
        dbJsonName="answers";

    }

    //questions construktor
    public JsonHandler(String kitchen) {
        this.kitchen = kitchen;
        path = "src/main/resources/" + kitchen + "_questions.json";
        dbJsonName="questions";
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
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return array;

    }
    //writes to the file from a JsonArray
    public void writeJsonArrayToFile(JSONArray entityAsJsonArray){

        JSONObject completeContent=new JSONObject();
        completeContent.put(dbJsonName,entityAsJsonArray);

        try {
            FileWriter file=new FileWriter(path);
            file.write(gson.toJson(completeContent));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}