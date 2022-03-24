package org.selenium.ojb;

public class DefaultUser {
    private String email;
    private String password;

    public DefaultUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
