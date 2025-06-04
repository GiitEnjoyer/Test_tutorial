package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewsTab {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private final By newsFeed = By.cssSelector(".news-feed");
    private final By firstPost = By.cssSelector(".post:nth-child(1)");
    private final By nextButton = By.cssSelector(".next-button");

    public NewsTab(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для проверки, что вкладка новостей загружена
    public boolean isNewsLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(newsFeed)).isDisplayed();
    }

    // Метод для просмотра первой новости
    public void viewFirstPost() {
        WebElement firstPostElement = wait.until(ExpectedConditions.elementToBeClickable(firstPost));
        firstPostElement.click();
    }

    // Метод для перехода к следующей странице новостей
    public void goToNextPage() {
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButtonElement.click();
    }

    // Метод для проверки наличия конкретного поста
    public boolean isPostPresent(String postText) {
        try {
            return driver.findElement(By.xpath("//div[contains(text(), '" + postText + "')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}