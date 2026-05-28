package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("timeout")
                        )
                )
        );
    }

    public void waitForVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element) {

        waitForVisibility(element);

        element.click();
    }

    public void enterText(WebElement element, String text) {

        waitForVisibility(element);

        element.clear();

        element.sendKeys(text);
    }

    public String getElementText(WebElement element) {

        waitForVisibility(element);

        return element.getText();
    }
}
