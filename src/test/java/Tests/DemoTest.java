package Tests;
import Pages.OyoRoomsLandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.ConfigReader;

public class DemoTest {
    static WebDriver driver = null;
    @Test
    public void SendCodeButtonValidation() {
        try {
            System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
            ConfigReader cfg = new ConfigReader();
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 20);
            driver.manage().window().maximize();
            driver.get(cfg.getPropValues("Url"));
            OyoRoomsLandingPage Ol = new OyoRoomsLandingPage(driver);
            Ol.EnterValueToHomeTown(cfg.getPropValues("Town"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'popup')][contains(@class,'geoSuggestionsList')]")));
            driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
            driver.switchTo().activeElement().sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'datePickerDesktop--home')]"))));
            Ol.EnterDateValue(cfg.getPropValues("StartDate"),cfg.getPropValues("EndDate"));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'guestRoomPicker--home')]"))));
            Ol.EnterGuestValue(cfg.getPropValues("Guests"));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Search']"))));
            driver.findElement(By.xpath("//button[text()='Search']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Book Now']"))).click();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='name']"))));
            driver.findElement(By.xpath("//input[@id='name']")).click();
            driver.switchTo().activeElement().sendKeys(cfg.getPropValues("TestFirstName"));
            driver.findElement(By.xpath("//input[@id='email']")).click();
            driver.switchTo().activeElement().sendKeys(cfg.getPropValues("TestEmail"));
            driver.findElement(By.xpath("//div[contains(@class,'Tel')]/input")).click();
            driver.switchTo().activeElement().sendKeys(cfg.getPropValues("TestNumber"));
            Assert.assertEquals("send passcodebutton is not enabled", true, driver.findElement(By.xpath("//span[text()='Send passcode']/..")).isEnabled());
        }
        catch(Exception g)
        {

        }
    }
    }



