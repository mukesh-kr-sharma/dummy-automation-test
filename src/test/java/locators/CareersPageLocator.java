package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Driver.getDriver;

public class CareersPageLocator {
    @FindBy(css = "nav.navbar")
    public WebElement navbar;

    @FindBy(xpath = "//div[contains(@class, 'page-header')]/h1")
    public WebElement header;

    @FindBy(id = "job_type")
    public WebElement jobTypeDropdown;

    @FindBy(xpath = "//table[@id='job-posts-table']/tbody/tr")
    public List<WebElement> jobPosts;

    @FindBy(xpath = "//table[@id='job-posts-table']//a[@class='job-title' and text()='QA Engineer']")
    public WebElement qaEngineerJob;

    @FindBy(xpath = "//table[@id='job-posts-table']//a[@class='job-title' and text()='QA Engineer']/ancestor::tr//button")
    public WebElement qaEngineerJobApplyBtn;

    /* Step 1 Locators */

    @FindBy(css = "#step1_status > a")
    public WebElement step1Status;

    @FindBy(css = "#step2_status > a")
    public WebElement step2Status;

    @FindBy(css = "#step3_status > a")
    public WebElement step3Status;

    @FindBy(xpath = "(//*[@id='step1']//h3)[1]")
    public WebElement personalDetailsHeader;

    @FindBy(id = "name_label")
    public WebElement firstNameLabel;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='firstName']/following-sibling::ul/li[@class='parsley-required']")
    public WebElement firstNameValidationFailedMsg;

    @FindBy(xpath = "//*[@id='lastName']/preceding-sibling::label")
    public WebElement lastNameLabel;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='lastName']/following-sibling::ul/li[@class='parsley-required']")
    public WebElement lastNameValidationFailedMsg;

    @FindBy(id = "email_label")
    public WebElement emailLabel;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='email']/following-sibling::ul/li[@class='parsley-required']")
    public WebElement emailValidationFailedMsg;

    @FindBy(id = "phone_label")
    public WebElement phoneLabel;

    @FindBy(id = "phone")
    public WebElement phoneInput;

    @FindBy(xpath = "//input[@id='phone']/following-sibling::ul/li[@class='parsley-required']")
    public WebElement phoneValidationFailedMsg;

    @FindBy(id = "sports_label")
    public WebElement sportsLabel;

    @FindBy(id = "sports")
    public WebElement sportsSelect;

    @FindBy(id = "pets_label")
    public WebElement petsLabel;

    @FindBy(id = "pets")
    public WebElement petsSelect;

    @FindBy(xpath = "//*[@id='current_city']/preceding-sibling::label")
    public WebElement currentCityLabel;

    @FindBy(id = "current_city")
    public WebElement currentCityInput;

    @FindBy(xpath = "//*[@id='hometown']/preceding-sibling::label")
    public WebElement hometownLabel;

    @FindBy(id = "hometown")
    public WebElement hometownInput;

    @FindBy(xpath = "//*[@id='dob']/preceding-sibling::label")
    public WebElement dobLabel;

    @FindBy(id = "dob")
    public WebElement dobInput;

    @FindBy(xpath = "//input[@id='dob']/following-sibling::ul/li[@class='parsley-required']")
    public WebElement dobValidationFailedMsg;

    @FindBy(id = "careers_form_btn_step1")
    public WebElement step1NextBtn;

    public CareersPageLocator() {
        PageFactory.initElements(getDriver(), this);
    }
}
