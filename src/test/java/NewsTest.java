import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class NewsTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @DisplayName("Проверка открытия новостей и взаимодействия с элементами страницы")
    @Tag("news")
    public void testNewsInteraction() {
        assertTimeoutPreemptively(Duration.ofMinutes(2), () -> {

            driver.get("https://ok.ru/profile/592527521743");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".user-profile")));


            homePage.openNewsTab();


            homePage.hoverOnStubImage();


            assertTrue(isElementPresent(homePage.newsTab));
            assertTrue(isElementPresent(homePage.stubImage));
        });
    }

    private boolean isElementPresent(By locator) {
        try {

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}