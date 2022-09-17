package stepDef;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.CommonUtils;
import utils.Driver;

public class Hooks {
    @Before
    public static void before(Scenario scenario) {
        CommonUtils.setScenario(scenario);
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Test step failed");
        }
    }
}

