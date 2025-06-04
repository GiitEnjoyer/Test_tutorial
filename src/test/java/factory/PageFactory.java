package factory;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private final WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public ProfilePage getProfilePage() {
        return new ProfilePage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }
}