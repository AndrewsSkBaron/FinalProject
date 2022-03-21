package org.selenium.utils;

import com.google.gson.Gson;
import org.selenium.ojb.User;


import java.io.*;
import java.nio.file.NoSuchFileException;

public class JsonParser {
    private static RandomGenerate random = new RandomGenerate();
    private final Gson gson = new Gson();

    public void createJson() {
        User newUser = new User("First Name", "Last Name",random.generateEmail(5) + "@gmail.com",random.generatePassword(8));
        try {
            FileWriter writer = new FileWriter("src/main/resources/json/user.json");
            writer.write(new Gson().toJson(newUser));
            writer.close();
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User readUserFromGson(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(reader.readLine(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
