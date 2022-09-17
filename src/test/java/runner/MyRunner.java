package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import utils.CommonUtils;
import utils.Driver;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/feature/Careers.feature"},
        glue = {"stepDef"},
        tags = "@Test"
)
public class MyRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    void beforeTest() {
        Driver.setupDriver();
        CommonUtils.hideMousePointer();
    }
}
