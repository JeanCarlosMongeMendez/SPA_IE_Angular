package cr.ac.ucr.spa.Selenium;

import cr.ac.ucr.spa.KendoDropdown;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;
import  org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

class StudentTest {

    private WebDriver driver;
    By getbtnAddStudent = By.id("btnAddStudent");

    By getidUsername = By.id("idUsername");
    By getidCard = By.id("idCard");
    By getidPassword = By.id("idPassword");
    By getidInterest = By.id("idInterest");
    By getidEmail = By.id("idEmail");

    By getidCanton = By.id("idCanton");
    By getidDistrict = By.id("idDistrict");

    By getidAsip = By.id("idAsip");

    By getbtnSubmit = By.id("btnSubmit");

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nee\\Documents\\UCR\\SPA_IE_Angular\\Selenium\\GeckoDriver\\geckodriver.exe");
        driver=new FirefoxDriver();
        //driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/student-list/APPROVED");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddCourse() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(getbtnAddStudent).click();
        Thread.sleep(2000);

        driver.findElement(getidUsername).sendKeys("Test");
        Thread.sleep(2000);
        driver.findElement(getidCard).sendKeys("30267952");
        Thread.sleep(2000);
        driver.findElement(getidPassword).sendKeys("123");
        Thread.sleep(2000);
        driver.findElement(getidInterest).sendKeys("Bailar");
        Thread.sleep(2000);
        driver.findElement(getidEmail).sendKeys("test@mail.com");
        Thread.sleep(4000);


        WebElement firstDropDown = driver.findElement(By.id("idProvince"));

        firstDropDown.click();

        List<WebElement> options = driver.findElements(By.cssSelector("[valueField]=\"'"));

        for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) {
            WebElement webElement = (WebElement) iterator.next();
            if (webElement.getText().equals("Cartago"))
                webElement.click();
        }


        Thread.sleep(4000);


        Select drpDistrict = new Select(driver.findElement(getidDistrict));
        drpDistrict.selectByVisibleText("Paraíso");
/*

        Select drpCanton = new Select(driver.findElement(getidCanton)).getOptions().get(2);
        drpCanton.selectByVisibleText("Paraíso");


*/
        Thread.sleep(2000);
        driver.findElement(getbtnSubmit).click();

        Thread.sleep(4000);
    }
}

