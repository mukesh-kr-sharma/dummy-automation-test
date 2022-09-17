package actions;

import locators.CareersPageLocator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;
import utils.Driver;

import java.time.Duration;

public class CareersPageAction {
    static CareersPageLocator locator = new CareersPageLocator();
    public static String getHeader() {
        return locator.header.getText();
    }
    public static void scrollToJobTypeDropdown() {
        int navbarHeight = locator.navbar.getRect().height;
        CommonUtils.scrollToElement(locator.jobTypeDropdown, navbarHeight + 50);
    }

    public static void scrollToQAEngineerOption() {
        int navbarHeight = locator.navbar.getRect().height;
        CommonUtils.scrollToElement(locator.qaEngineerJob, navbarHeight + 150);
    }
    public static void selectJobType(String jobType) {
        new Select(locator.jobTypeDropdown).selectByVisibleText(jobType);
    }
    public static String getJobTableMessage() {
        return locator.jobPosts.get(0).getText();
    }

    public static void clickQAEngineerOption() {
        locator.qaEngineerJob.click();
    }

    public static void hoverQAEngineerOption() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(locator.qaEngineerJob).perform();
    }

    public static void clickQAEngineerApplyBtn() {
        locator.qaEngineerJobApplyBtn.click();
    }

    public static String getStepStatusColor(String step) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator.step1Status));

        WebElement stepLocator = null;
        switch (step) {
            case "Step 1":
                stepLocator = locator.step1Status;
                break;
            case "Step 2":
                stepLocator = locator.step2Status;
                break;
            case "Step 3":
                stepLocator = locator.step3Status;
                break;
            default:
                throw new NoSuchElementException("Invalid step selection");
        }

        String color = (String) Driver.getJsExecutor().executeScript(
                "return window.getComputedStyle(arguments[0]).backgroundColor",
                stepLocator);
        if(color.equals("rgb(251, 232, 170)"))
            return "Yellow";
        else if (color.equals("rgb(245, 245, 245)"))
            return "Gray";
        return "Gray";
    }

    public static String getPersonalDetailsHeaderText() {
        return locator.personalDetailsHeader.getText();
    }

    public static String getFirstNameLabel() {
        return locator.firstNameLabel.getText();
    }

    public static void inputFirstName(String input) {
        locator.firstNameInput.sendKeys(input);
    }

    public static String getFirstNameValidationFailedMsg() {
        return locator.firstNameValidationFailedMsg.getText();
    }

    public static String getLastNameLabel() {
        return locator.lastNameLabel.getText();
    }

    public static void inputLastName(String input) {
        locator.lastNameInput.sendKeys(input);
    }

    public static String getLastNameValidationFailedMsg() {
        return locator.lastNameValidationFailedMsg.getText();
    }

    public static String getEmailLabel() {
        return locator.emailLabel.getText();
    }

    public static void inputEmail(String input) {
        locator.emailInput.sendKeys(input);
    }

    public static String getEmailValidationFailedMsg() {
        return locator.emailValidationFailedMsg.getText();
    }

    public static String getPhoneLabel() {
        return locator.phoneLabel.getText();
    }

    public static void inputPhone(String input) {
        locator.phoneInput.sendKeys(input);
    }

    public static String getPhoneValidationFailedMsg() {
        return locator.phoneValidationFailedMsg.getText();
    }

    public static String getSportLabel() {
        return locator.sportsLabel.getText();
    }

    public static void selectSports(String option) {
        new Select(locator.sportsSelect).selectByVisibleText(option);
    }

    public static String getPetLabel() {
        return locator.petsLabel.getText();
    }

    public static void selectPet(String option) {
        new Select(locator.petsSelect).selectByVisibleText(option);
    }

    public static String getCurrentCityLabel() {
        return locator.currentCityLabel.getText();
    }

    public static void inputCurrentCity(String input) {
        locator.currentCityInput.sendKeys(input);
    }

    public static String getHometownLabel() {
        return locator.hometownLabel.getText();
    }

    public static void inputHometown(String input) {
        locator.hometownInput.sendKeys(input);
    }

    public static String getDobLabel() {
        return locator.dobLabel.getText();
    }

    public static void inputDob(String input) {
        locator.dobInput.sendKeys(input);
    }

    public static String getDobValidationFailedMsg() {
        return locator.dobValidationFailedMsg.getText();
    }

    public static void scrollToStep1NextBtn() {
        CommonUtils.scrollToElement(locator.step1NextBtn, 250);
    }

    public static void clickOnStep1NextBtn() {
        locator.step1NextBtn.click();
    }
}
