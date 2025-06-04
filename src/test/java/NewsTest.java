import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class NewsTest {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;


    private final By newsTab = By.cssSelector(".nav-side_i-w:nth-child(2) .tico");
    private final By stubImage = By.cssSelector(".stub-img__288");

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(922, 894));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка открытия новостей и взаимодействия с элементами страницы")
    @Tag("news")
    public void testNewsInteraction() {
        assertTimeoutPreemptively(Duration.ofMinutes(2), () -> {

            driver.get("https://ok.ru/profile/592527521743");


            clickWithWait(newsTab);


            hoverOn(stubImage);


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");


            assertAll(
                    () -> assertTrue(isElementDisplayed(newsTab)),
                    () -> assertTrue(isElementDisplayed(stubImage))
            );
        });
    }



    private void clickWithWait(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void hoverOn(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }

    private boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}