package org.selenium.pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {
    private By waitForm = By.xpath("//form[@id='account-creation_form']");
    private By checkBox = By.xpath("//input[@id='id_gender1']");
    private By firstName = By.xpath("//input[@id='customer_firstname']");
    private By lastName = By.xpath("//input[@id='customer_lastname']");
    private By password = By.xpath("//input[@id='passwd']");
    private By days = By.xpath("//select[@id='days']");
    private By day = By.xpath("//select[@id='days']//option[@value='11']");
    private By months = By.xpath("//select[@id='months']");
    private By month = By.xpath("//select[@id='months']//option[@value='10']");
    private By years = By.xpath("//select[@id='years']");
    private By year = By.xpath("//select[@id='years']//option[@value='1980']");
    private By checkBoxNews = By.xpath("//input[@id='newsletter']");
    private By checkBoxOption = By.xpath("//input[@id='optin']");
    private By firstName2 = By.xpath("//input[@id='firstname']");
    private By lastName2 = By.xpath("//input[@id='lastname']");
    private By company = By.xpath("//input[@id='company']");
    private By address = By.xpath("//input[@id='address1']");
    private By address2 = By.xpath("//input[@id='address2']");
    private By city = By.xpath("//input[@id='city']");
    private By states = By.xpath("//select[@id='id_state']");
    private By state = By.xpath("//select[@id='id_state']//option[@value='46']");
    private By zip = By.xpath("//input[@id='postcode']");
    private By countries = By.xpath("//select[@id='id_country']");
    private By country = By.xpath("//select[@id='id_country']//option[normalize-space()='United States']");
    private By textarea = By.xpath("//textarea[@id='other']");
    private By homePhone = By.xpath("//input[@id='phone']");
    private By mobilePhone = By.xpath("//input[@id='phone_mobile']");
    private By aliasAddress = By.xpath("//input[@id='alias']");
    private By buttonRegister = By.xpath("//button[@id='submitAccount']");

    public RegistrationPage sendInfo() {
        driver.findElement(checkBox).click();
        driver.findElement(firstName).sendKeys(user.getFirstName());
        driver.findElement(lastName).sendKeys(user.getLastName());
        driver.findElement(password).sendKeys(user.getPassword());
        selectedData();
        driver.findElement(checkBoxNews).click();
        driver.findElement(checkBoxOption).click();
        driver.findElement(firstName2).sendKeys(user.getFirstName());
        driver.findElement(lastName2).sendKeys(user.getLastName());
        driver.findElement(company).sendKeys("TestCompany");
        driver.findElement(address).sendKeys("testAddressStreet");
        driver.findElement(address2).sendKeys("testAddressStreet2");
        driver.findElement(city).sendKeys("testCity");
        driver.findElement(states).click();
        driver.findElement(state).click();
        driver.findElement(zip).sendKeys("55416");
        driver.findElement(countries).click();
        driver.findElement(country).click();
        driver.findElement(textarea).sendKeys("Test test Test");
        driver.findElement(homePhone).sendKeys("+11111111111");
        driver.findElement(mobilePhone).sendKeys("+22222222222");
        driver.findElement(aliasAddress).clear();
        driver.findElement(aliasAddress).sendKeys("testAliasAddressStreet");
        driver.findElement(buttonRegister).click();
        return this;
    }

    public void selectedData() {
        driver.findElement(days).click();
        driver.findElement(day).click();
        driver.findElement(months).click();
        driver.findElement(month).click();
        driver.findElement(years).click();
        driver.findElement(year).click();
    }

    public MyAccountPage createAccount() {
        sendInfo();
        return new MyAccountPage();
    }

}
