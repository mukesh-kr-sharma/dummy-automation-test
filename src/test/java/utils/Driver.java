package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;
    public static void setupDriver() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }
    public static JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) driver;
    }
}
