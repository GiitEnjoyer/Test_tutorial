import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class loggin {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testloggin() {
        driver.get("https://ok.ru/");
        driver.manage().window().setSize(new Dimension(550, 691));
        driver.findElement(By.id("field_email")).sendKeys("technopol38");
        driver.findElement(By.id("field_password")).click();
        driver.findElement(By.id("field_password")).sendKeys("technopolisPassword");
        driver.findElement(By.cssSelector(".\\__wide:nth-child(1)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".card-wrapper__ylpz6:nth-child(3) .content__aj603"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        js.executeScript("window.scrollTo(0,0)");
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".lcTc_avatar"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".feed-w:nth-child(4) > .feed")).click();
        driver.close();
    }
}
