package org.selenium.utils;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.selenium.ojb.User;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Locale;

public class JsonParser {
    private static RandomGenerate random = new RandomGenerate();
    private static Faker faker = new Faker();
    private final Gson gson = new Gson();

    public void createJson() {
        User newUser = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                random.generateEmail(5) + "@gmail.com",
                random.generatePassword(8),
                faker.company().name().toLowerCase(Locale.ROOT),
                faker.address().streetAddress().toLowerCase(Locale.ROOT),
                faker.address().streetAddress().toLowerCase(Locale.ROOT),
                faker.address().city().toLowerCase(Locale.ROOT),
                faker.address().zipCode().substring(0,6 -1),
                "+"+faker.phoneNumber().cellPhone().stripIndent(),
                "+"+faker.phoneNumber().cellPhone().stripIndent(),
                faker.address().streetAddress().toLowerCase(Locale.ROOT),
                faker.demographic().sex());
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

    public User readUserFromGson() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/json/user.json"))) {
            return gson.fromJson(reader.readLine(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
