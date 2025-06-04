import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class homepage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;


    private final By notesLink = By.linkText("Заметки");
    private final By photosLink = By.linkText("Фото 3");
    private final By newPhotosLink = By.linkText("Новые фотографии");
    private final By firstPhoto = By.cssSelector(".uslider_i:nth-child(1) .photo_img");
    private final By nextButton = By.cssSelector(".__next__2qn5b svg");
    private final By closeButton = By.cssSelector(".__size-24__ijkqc > .svg-fill");

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(922, 895));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка навигации по фотоальбому и работа с просмотром фото")
    public void testPhotoNavigation() {
        assertTimeoutPreemptively(Duration.ofMinutes(2), () -> {
            driver.get("https://ok.ru/profile/592527521743");


            hoverOn(notesLink);
            hoverOn(photosLink);
            hoverOn(newPhotosLink);


            clickWithWait(firstPhoto);


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");


            clickWithWait(nextButton);
            clickWithWait(nextButton);


            clickWithWait(closeButton);


            assertAll(
                    () -> assertTrue(isElementDisplayed(notesLink)),
                    () -> assertTrue(isElementDisplayed(photosLink))
            );
        });
    }



    private void hoverOn(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    private void clickWithWait(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}