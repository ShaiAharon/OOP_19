package com.ariel;

import com.google.gson.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final String json_path = "src/example.json";


//        // Reading json object
//        JsonObject jsonObject = new JsonObject();
//        try {
//            String json_str = new String(Files.readAllBytes(Paths.get(json_path)));
//            jsonObject = JsonParser.parseString(json_str).getAsJsonObject();
//
//            System.out.println(jsonObject.toString().replace(",", "\n\t"));
//            System.out.println(jsonObject.get("nick_name"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // Create Json from ground-up
//        JsonObject my_json = new JsonObject();
//        my_json.addProperty("title", "Dr.");
//        my_json.addProperty("name", "Who");
//        my_json.addProperty("type", "TimeLord");
//        my_json.addProperty("doctor_num", 9);
//        my_json.addProperty("heart_num", 2);
//
//        JsonArray jsonArray = new JsonArray();
//        jsonArray.add("Rose Tyler");
//        jsonArray.add("Adam Mitchell");
//        jsonArray.add("Captain Jack Harkness");
//
//        my_json.add("companions", jsonArray);
//        System.out.println(my_json.toString().replace(",", "\n\t"));

        // Create Json from Object
        Gson gson = new Gson();
        String dr_json_str = gson.toJson(new DrWho());
        System.out.println(dr_json_str.toString().replace(",", "\n\t"));

        // Save the object to a file
        Path file = Paths.get("my_drwho.json");
        try {
            Files.write(file, Arrays.asList(dr_json_str), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the json to an object
        try {
            String json_str = new String(Files.readAllBytes(file));
            DrWho loaded_dr = gson.fromJson(json_str,DrWho.class);

            System.out.println(loaded_dr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
