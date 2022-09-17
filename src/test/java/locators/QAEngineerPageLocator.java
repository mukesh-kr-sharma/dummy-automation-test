package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class QAEngineerPageLocator {
    @FindBy(xpath = "//header//h1")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@class, 'btn-red') and text()='Apply here now']")
    public WebElement applyHereNowBtn;

    public QAEngineerPageLocator() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
