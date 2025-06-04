package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Link {

    private WebDriver driver;
    private By locator;
    private WebElement element;

    // Конструктор с локатором
    public Link(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        this.element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Клик по ссылке
    public void click() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    // Получение текста ссылки
    public String getText() {
        return element.getText();
    }

    // Получение href атрибута
    public String getHref() {
        return element.getAttribute("href");
    }

    // Проверка, что ссылка видна
    public boolean isDisplayed() {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Проверка, что ссылка активна
    public boolean isEnabled() {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}