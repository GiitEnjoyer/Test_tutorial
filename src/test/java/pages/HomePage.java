package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // Локаторы
    public final By newsTab = By.cssSelector(".nav-side_i-w:nth-child(2) .tico");
    public final By stubImage = By.cssSelector(".stub-img__288");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void openNewsTab() {
        WebElement newsTabElement = wait.until(ExpectedConditions.elementToBeClickable(newsTab));
        newsTabElement.click();
    }

    public void hoverOnStubImage() {
        WebElement stubImageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(stubImage));
        actions.moveToElement(stubImageElement).perform();
    }
}