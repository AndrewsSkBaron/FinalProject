package org.selenium.utils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerate {
    private final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBER = "0123456789";
    private final String PASSWORD_ALLOW_BASE = CHAR_LOWER + NUMBER;
    private final String PASSWORD_ALLOW_BASE_SHUFFLE = shuffleString(PASSWORD_ALLOW_BASE);
    private final String PASSWORD_ALLOW = PASSWORD_ALLOW_BASE_SHUFFLE;
    private final String EMAIL_ALLOW_BASE = CHAR_LOWER;
    private final String EMAIL_ALLOW_BASE_SHUFFLE = shuffleString(EMAIL_ALLOW_BASE);
    private final String EMAIL_ALLOW = EMAIL_ALLOW_BASE_SHUFFLE;

    private SecureRandom random = new SecureRandom();

    public String generatePassword(int length) {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(PASSWORD_ALLOW.length());
            char rndChar = PASSWORD_ALLOW.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

    public String generateEmail(int length) {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(EMAIL_ALLOW.length());
            char rndChar = EMAIL_ALLOW.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

    public String shuffleString(String string) {
        List letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return (String) letters.stream().collect(Collectors.joining());
    }

}
