package org.selenium.ojb;

import com.github.javafaker.Address;

import java.util.Date;

public final class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /*Select Date of Birth*/
//    private String date;
//    private String month;
//    private String year;

    private String company;
    private String address1;
    private String address2;
    private String city;

//    /*Select state*/
//    private String state;

    private String zip;
//
//    /*Select Country*/
//    private String country;

    private String homePhone;
    private String mobilePhone;
    private String addressAlias;
    private String someText;

    public User(String firstName, String lastName, String email, String password, String company, String address1,
                String address2, String city, String zip, String homePhone, String mobilePhone, String addressAlias, String someText) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zip = zip;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
        this.someText = someText;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public String getSomeText() {
        return someText;
    }

    @Override
    public String toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' + '\n' +
                ", lastName='" + lastName + '\'' + '\n' +
                ", email='" + email + '\'' + '\n' +
                ", password='" + password + '\'' + '\n' +
                ", company='" + company + '\'' + '\n' +
                ", address1='" + address1 + '\'' + '\n' +
                ", address2='" + address2 + '\'' + '\n' +
                ", city='" + city + '\'' + '\n' +
                ", zip='" + zip + '\'' + '\n' +
                ", homePhone='" + homePhone + '\'' + '\n' +
                ", mobilePhone='" + mobilePhone + '\'' + '\n' +
                ", addressAlias='" + addressAlias + '\'' + '\n' +
                '}';
    }
}
