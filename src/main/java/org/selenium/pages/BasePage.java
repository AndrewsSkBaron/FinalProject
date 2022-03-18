package org.selenium.pages;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.driver.Driver;
import org.selenium.ojb.User;
import org.selenium.utils.RandomGenerate;

import java.io.*;
import java.nio.file.NoSuchFileException;

public abstract class BasePage {
    protected WebDriver driver = Driver.getInstance().getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 30);
    private static RandomGenerate random = new RandomGenerate();
    private final Gson gson = new Gson();
    protected User user = readUserFromGson(new File("src/main/resources/json/user.json"));

    static  {
        createJson();
    }

    public static void createJson() {
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

    private User readUserFromGson(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(reader.readLine(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected boolean isElementPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
