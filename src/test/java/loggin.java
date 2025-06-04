import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class loggin {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    // Локаторы
    private final By emailField = By.id("field_email");
    private final By passwordField = By.id("field_password");
    private final By loginButton = By.cssSelector(".__wide:nth-child(1)");
    private final By hoverElementOnCard = By.cssSelector(".card-wrapper__ylpz6:nth-child(3) .content__aj603");
    private final By avatarIcon = By.cssSelector(".lcTc_avatar");
    private final By feedItem = By.cssSelector(".feed-w:nth-child(4) > .feed");

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
    @DisplayName("Тест входа в аккаунт и взаимодействия с интерфейсом")
    @Tag("login")
    public void testLoginAndInteractions() {
        assertTimeoutPreemptively(Duration.ofMinutes(2), () -> {
            // Открытие страницы
            driver.get("https://ok.ru/");

            // Ввод логина и пароля
            enterText(emailField, "technopol38");
            enterText(passwordField, "technopolisPassword");

            // Клик по кнопке входа
            clickWithWait(loginButton);

            // Наведение мыши на карточку
            hoverOn(hoverElementOnCard);

            // Скролл вверх
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

            // Наведение на аватар
            hoverOn(avatarIcon);

            // Клик по элементу в ленте
            clickWithWait(feedItem);

            // Проверки
            assertAll(
                    () -> assertTrue(isElementDisplayed(emailField)),
                    () -> assertTrue(isElementDisplayed(passwordField))
            );
        });
    }

    // Вспомогательные методы

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    private void clickWithWait(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void hoverOn(By locator) {
        WebElement element = driver.findElement(locator);
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