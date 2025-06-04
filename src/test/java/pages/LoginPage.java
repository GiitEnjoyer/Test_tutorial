package pages;

import components.Button;
import components.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {
    private WebDriver driver;
    private InputField usernameField;
    private InputField passwordField;
    private Button loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.usernameField = new InputField(driver, By.id("field_email"));
        this.passwordField = new InputField(driver, By.id("field_password"));
        this.loginButton = new Button(driver, By.cssSelector(".__wide:nth-child(1)"));
    }

    public void open() {
        driver.get("https://ok.ru/");
    }

    public ProfilePage login(String username, String password) {
        usernameField.enterText(username);
        passwordField.enterText(password);
        loginButton.click();
        return new ProfilePage(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        // Проверяем, что мы на странице входа
        assert driver.getCurrentUrl().contains("ok.ru") : "Не на главной странице";
    }

    @Override
    protected void load() {
        open();
    }
}