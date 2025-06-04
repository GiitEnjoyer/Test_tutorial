
import data.UserDataProvider;
import model.User;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setupPages() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Тест: успешный вход с корректными данными")
    public void testSuccessfulLogin() {
        loginPage.open();

        User validUser = UserDataProvider.getTestUsers().get(0);
        ProfilePage profilePage = loginPage.login(validUser.getUsername(), validUser.getPassword());

        assertTrue(profilePage.isProfileLoaded());
    }
}