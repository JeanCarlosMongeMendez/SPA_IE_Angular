package cr.ac.ucr.spa.Selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

class LoginProfessorTest {

    private WebDriver driver;
    By getBtnRegisterProfessor = By.id("btnSignProfessor");
    By getImpUsername = By.id("idImpUsername");
    By getImpPassword = By.id("idImpPassword");
    By getSubmitBtn = By.id("btnSubmitLogin");

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nee\\Documents\\UCR\\SPA_IE_Angular\\Selenium\\GeckoDriver\\geckodriver.exe");
        driver=new FirefoxDriver();
        //driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginProfessor() throws InterruptedException {
        driver.findElement(getBtnRegisterProfessor).click();
        Thread.sleep(2000);

        driver.findElement(getImpUsername).sendKeys("Diana");
        Thread.sleep(2000);
        driver.findElement(getImpPassword).sendKeys("123");

        Thread.sleep(2000);
        driver.findElement(getSubmitBtn).click();
        Thread.sleep(4000);
    }
}