package utils;

import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.File;

public class CommonUtils {
    private static Scenario scenario;

    public static void setScenario(Scenario scenario) {
        CommonUtils.scenario = scenario;
    }
    public static void scrollToElement(WebElement element, int offset) {
        Driver.getJsExecutor().executeScript(
                    "var element = arguments[0];" +
                        "var headerOffset = arguments[1];" +
                        "var elementPosition = element.getBoundingClientRect().top;" +
                        "var offsetPosition = elementPosition + window.pageYOffset - headerOffset;" +
                        "window.scrollTo({" +
                        "   top: offsetPosition," +
                        "   behavior: 'smooth'" +
                        "});",
                element, offset);
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {}
    }

    public static void pressTabBtn() {
        new Actions(Driver.getDriver()).sendKeys(Keys.TAB).perform();
    }

    @SneakyThrows
    public static void takeScreenshot(String screenshotName) {
        File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", ">> Screenshot : " + screenshotName);
    }

    public static void log(String message) {
        scenario.log(">> Log : " + message);
    }

    @SneakyThrows
    public static void hideMousePointer() {
        Robot robot = new Robot();
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        robot.mouseMove(x, 0);
    }
}
