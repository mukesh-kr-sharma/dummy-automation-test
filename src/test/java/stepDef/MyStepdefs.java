package stepDef;

import actions.CareersPageAction;
import actions.QAEngineerPageAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.CommonUtils;
import utils.Driver;

import java.util.Arrays;

public class MyStepdefs {
    @Given("I open page {string}")
    public void openURL(String URL) {
        Driver.getDriver().get(URL);
        CommonUtils.sleep(2000);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Careers | Numadic");
        CommonUtils.takeScreenshot("Numadic Career Page opened - " + URL);
    }
    @Then("I verify header {string}")
    public void verifyHeader(String header) {
        String headerTest = CareersPageAction.getHeader();
        Assert.assertEquals(headerTest, header);
        CommonUtils.log("Verified header - " + header);
    }
    @Then("I select job type {string} from {string} dropdown")
    public void i_select_from_dropdown(String jobType, String dropdown) {
        if ("Job type".equals(dropdown)) {
            CareersPageAction.scrollToJobTypeDropdown();
            CommonUtils.sleep(1000);
            CommonUtils.log("Scrolled down to Job Type dropdown");
            CareersPageAction.selectJobType(jobType);
            CommonUtils.takeScreenshot("Selected job type - " + jobType);
            CommonUtils.sleep(1000);
        } else {
            throw new NoSuchElementException("Invalid dropdown option");
        }
    }

    @And("I verify message {string}")
    public void verifyMessage(String message) {
        String jobTableMessage = CareersPageAction.getJobTableMessage();
        Assert.assertEquals(message, jobTableMessage);
        CommonUtils.takeScreenshot("Job table message verified - " + message);
    }

    @Then("I click on job {string}")
    public void clickOnJob(String job) {
        if(job.equals("QA Engineer")) {
            CareersPageAction.scrollToQAEngineerOption();
            CommonUtils.log("Scrolled to QA Engineer job link");
            CommonUtils.sleep(2000);
            CareersPageAction.clickQAEngineerOption();
            CommonUtils.sleep(2000);
            CommonUtils.takeScreenshot("Clicked on 'QA Engineer' button");
        } else {
            throw new NoSuchElementException("Invalid job option");
        }
    }

    @And("I verify page URL {string}")
    public void verifyPageURL(String URL) {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), URL);
        CommonUtils.log("Verified page URL - " + URL);
        CommonUtils.sleep(1000);
    }

    @And("I validate button {string} in {string} page")
    public void validateButton(String buttonText, String page) {
        if ("QA Engineer".equals(page)) {
            if (buttonText.equals("Apply here now")) {
                QAEngineerPageAction.scrollToApplyBtn();
                CommonUtils.log("Scrolled down to 'Apply here now' button");
                CommonUtils.sleep(1500);
                Assert.assertTrue(QAEngineerPageAction.isVisibleEnabledApplyBtn());
                CommonUtils.takeScreenshot("Validated 'Apply here now' button");
            } else {
                throw new NoSuchElementException("Invalid button");
            }
        } else {
            throw new NoSuchElementException("Invalid page selected");
        }
    }

    @Then("I click on button {string} in {string} page")
    public void clickOnButton(String button, String page) {
        if ("QA Engineer".equals(page)) {
            if (button.equals("Apply here now")) {
                QAEngineerPageAction.clickApplyHereNowBtn();
            } else {
                throw new NoSuchElementException("Invalid button selected");
            }
            CommonUtils.sleep(2000);
            CommonUtils.takeScreenshot("Clicked on button - " + button);
        } else {
            throw new NoSuchElementException("Invalid page selected");
        }
    }

    @And("It gets redirected to {string} page")
    public void itGetsRedirectedToPage(String page) {
        if (page.equals("Careers")) {
            Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://numadic.com/careers/#careersFormContainer");
            CommonUtils.log("Validated redirection to career page - " + Driver.getDriver().getCurrentUrl());
            Assert.assertEquals(Driver.getDriver().getTitle(), "Careers | Numadic");
            CommonUtils.log("Validated title of the page - " + "Careers | Numadic");
        } else {
            throw new NoSuchElementException("Invalid page selected");
        }
    }

    @Then("I hover over {string} job and click on {string} button")
    public void hoverAndClickJob(String job, String button) {
        if (job.equals("QA Engineer")) {
            CareersPageAction.scrollToQAEngineerOption();
            CommonUtils.log("Scrolled up to QA Engineer link");
            CommonUtils.sleep(1000);
            CareersPageAction.hoverQAEngineerOption();
            CommonUtils.takeScreenshot("Hovered over QA Engineer link");
            CommonUtils.sleep(1000);
            CareersPageAction.clickQAEngineerApplyBtn();
            CommonUtils.sleep(4000);
            CommonUtils.takeScreenshot("Clicked on 'Apply' button");
        } else {
            throw new NoSuchElementException("Invalid Job");
        }
    }

    @Then("I validate all fields in {string} section")
    public void validateAllFieldsInSection(String section) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(CareersPageAction.getStepStatusColor("Step 1"), "Yellow");
        CommonUtils.log("Step 1 color - " + CareersPageAction.getStepStatusColor("Step 1"));

        softAssert.assertEquals(CareersPageAction.getPersonalDetailsHeaderText(), "Personal details");
        CommonUtils.log("Personal Details Header Text - " + CareersPageAction.getPersonalDetailsHeaderText());

        softAssert.assertEquals(CareersPageAction.getFirstNameLabel(), "First name");
        CommonUtils.log("First Name Label - " + CareersPageAction.getFirstNameLabel());

        softAssert.assertEquals(CareersPageAction.getLastNameLabel(), "Last name");
        CommonUtils.log("Last Name Label - " + CareersPageAction.getLastNameLabel());

        softAssert.assertEquals(CareersPageAction.getEmailLabel(), "Email");
        CommonUtils.log("Email Label - " + CareersPageAction.getEmailLabel());

        softAssert.assertEquals(CareersPageAction.getPhoneLabel(), "Mobile");
        CommonUtils.log("Phone Label - " + CareersPageAction.getPhoneLabel());

        softAssert.assertEquals(CareersPageAction.getSportLabel(), "Sports you watch and/or play?");
        CommonUtils.log("Sports Label - " + CareersPageAction.getSportLabel());

        softAssert.assertEquals(CareersPageAction.getPetLabel(), "Dogs or Cats?");
        CommonUtils.log("Pets Label - " + CareersPageAction.getPetLabel());

        softAssert.assertEquals(CareersPageAction.getCurrentCityLabel(), "Current city");
        CommonUtils.log("Current City Label - " + CareersPageAction.getCurrentCityLabel());

        softAssert.assertEquals(CareersPageAction.getHometownLabel(), "Hometown");
        CommonUtils.log("Hometown Label - " + CareersPageAction.getHometownLabel());

        softAssert.assertEquals(CareersPageAction.getDobLabel(), "Date of birth");
        CommonUtils.log("Date of birth Label - " + CareersPageAction.getDobLabel());

        CommonUtils.takeScreenshot("Validated all labels in Personal Details");

        CareersPageAction.scrollToStep1NextBtn();
        CommonUtils.sleep(1500);
        CommonUtils.takeScreenshot("Scrolled down to Next button");
        CareersPageAction.clickOnStep1NextBtn();
        CommonUtils.sleep(1000);
        CommonUtils.takeScreenshot("Clicked on next button");

        CommonUtils.log("Validation failure messages displayed");

        softAssert.assertEquals(CareersPageAction.getFirstNameValidationFailedMsg(), "Enter your first name");
        CommonUtils.log("First name validation failure message - " + CareersPageAction.getFirstNameValidationFailedMsg());

        softAssert.assertEquals(CareersPageAction.getLastNameValidationFailedMsg(), "Enter your last name");
        CommonUtils.log("Last name validation failure message - " + CareersPageAction.getLastNameValidationFailedMsg());

        softAssert.assertEquals(CareersPageAction.getEmailValidationFailedMsg(), "Enter an email");
        CommonUtils.log("Email validation failure message - " + CareersPageAction.getEmailValidationFailedMsg());

        softAssert.assertEquals(CareersPageAction.getPhoneValidationFailedMsg(), "Enter your mobile number");
        CommonUtils.log("Phone number validation failure message - " + CareersPageAction.getPhoneValidationFailedMsg());

        softAssert.assertEquals(CareersPageAction.getDobValidationFailedMsg(), "Enter your date of birth");
        CommonUtils.log("Date of birth validation failure message - " + CareersPageAction.getDobValidationFailedMsg());

        String[] tempValues = {
                "Joe",
                "Biden",
                "joe.biden@testing.com",
                "9876543210",
                "Cricket",
                "Pokemon",
                "Goa",
                "Kolkata",
                "15/02/1992"
        };

        CareersPageAction.inputFirstName(tempValues[0]);
        CareersPageAction.inputLastName(tempValues[1]);
        CareersPageAction.inputEmail(tempValues[2]);
        CareersPageAction.inputPhone(tempValues[3]);
        CareersPageAction.selectSports(tempValues[4]);
        CareersPageAction.selectPet(tempValues[5]);
        CareersPageAction.inputCurrentCity(tempValues[6]);
        CareersPageAction.inputHometown(tempValues[7]);
        CareersPageAction.inputDob(tempValues[8]);
        CommonUtils.pressTabBtn();

        CommonUtils.takeScreenshot("Entered all temporary details - " + Arrays.toString(tempValues));
        CommonUtils.log("Asserting all the above validations");
        softAssert.assertAll();
    }
}
