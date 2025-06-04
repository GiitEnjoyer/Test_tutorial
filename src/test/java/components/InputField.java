package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputField {
    private WebDriver driver;
    private By locator;
    private WebElement element;

    public InputField(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        this.element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void enterText(String text) {
        element.clear();
        element.sendKeys(text);
    }

    public String getText() {
        return element.getAttribute("value");
    }

    public boolean isDisplayed() {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}