package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RegistrationPage extends BasePage {
    private By waitForm = By.xpath("//form[@id='account-creation_form']");
    private By checkBox = By.xpath("//input[@id='id_gender1']");
    private By firstName = By.xpath("//input[@id='customer_firstname']");
    private By lastName = By.xpath("//input[@id='customer_lastname']");
    private By password = By.xpath("//input[@id='passwd']");
    private By days = By.xpath("//select[@id='days']");
    private By months = By.xpath("//select[@id='months']");
    private By years = By.xpath("//select[@id='years']");
    private By checkBoxNews = By.xpath("//input[@id='newsletter']");
    private By checkBoxOption = By.xpath("//input[@id='optin']");
    private By firstName2 = By.xpath("//input[@id='firstname']");
    private By lastName2 = By.xpath("//input[@id='lastname']");
    private By company = By.xpath("//input[@id='company']");
    private By address = By.xpath("//input[@id='address1']");
    private By address2 = By.xpath("//input[@id='address2']");
    private By city = By.xpath("//input[@id='city']");
    private By states = By.xpath("//select[@id='id_state']");
    private By zip = By.xpath("//input[@id='postcode']");
    private By countries = By.xpath("//select[@id='id_country']");
    private By textarea = By.xpath("//textarea[@id='other']");
    private By homePhone = By.xpath("//input[@id='phone']");
    private By mobilePhone = By.xpath("//input[@id='phone_mobile']");
    private By aliasAddress = By.xpath("//input[@id='alias']");
    private By buttonRegister = By.xpath("//button[@id='submitAccount']");
    private Select select;

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MyAccountPage createAccount(int data, int month, int year, String state, int country) {
        wait.until(visibilityOfElementLocated(waitForm));
        sendTextInformation();
        setCheckBox();
        selectedData(data);
        selectedMonth(month);
        selectedYear(year);
        selectedState(state);
        selectedCountry(country);
        driver.findElement(buttonRegister).click();
        return new MyAccountPage(driver, wait);
    }

    private void setCheckBox() {
        driver.findElement(checkBoxNews).click();
        driver.findElement(checkBoxOption).click();
        driver.findElement(checkBox).click();
    }

    private void selectedData(int data) {
        select = new Select(driver.findElement(days));
        driver.findElement(days).click();
        select.selectByValue(String.valueOf(data));
    }

    private void selectedMonth(int month) {
        select = new Select(driver.findElement(months));
        driver.findElement(months).click();
        select.selectByValue(String.valueOf(month));
    }

    private void selectedYear(int year) {
        select = new Select(driver.findElement(years));
        driver.findElement(years).click();
        select.selectByValue(String.valueOf(year));
    }

    private void selectedState(String state) {
        select = new Select(driver.findElement(states));
        driver.findElement(states).click();
        select.selectByVisibleText(state);
    }

    private void selectedCountry(int country) {
        select = new Select(driver.findElement(countries));
        driver.findElement(countries).click();
        select.selectByValue(String.valueOf(country));
    }

    private void sendTextInformation() {
        driver.findElement(firstName).sendKeys(user.getFirstName());
        driver.findElement(lastName).sendKeys(user.getLastName());
        driver.findElement(password).sendKeys(user.getPassword());
        driver.findElement(firstName2).sendKeys(user.getFirstName());
        driver.findElement(lastName2).sendKeys(user.getLastName());
        driver.findElement(company).sendKeys(user.getCompany());
        driver.findElement(address).sendKeys(user.getAddress1());
        driver.findElement(address2).sendKeys(user.getAddress2());
        driver.findElement(city).sendKeys(user.getCity());
        driver.findElement(zip).sendKeys(user.getZip());
        driver.findElement(textarea).sendKeys(user.getSomeText());
        driver.findElement(homePhone).sendKeys(user.getHomePhone());
        driver.findElement(mobilePhone).sendKeys(user.getMobilePhone());
        driver.findElement(aliasAddress).clear();
        driver.findElement(aliasAddress).sendKeys(user.getAddressAlias());
    }

}
