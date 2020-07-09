package cr.ac.ucr.spa.Selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    private WebDriver driver;
    By getbtnAddCourse = By.id("btnAddCourse");
    By getidName = By.id("idName");
    By getidSemester = By.id("idSemester");
    By getidDescription = By.id("idDescription");
    By getidImage = By.id("idImage");
    By getidState = By.id("idState");
    By getidDate = By.id("idDate");
    By getbtnSubmit = By.id("btnSubmit");

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nee\\Documents\\UCR\\SPA_IE_Angular\\Selenium\\GeckoDriver\\geckodriver.exe");
        driver=new FirefoxDriver();
        //driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/list-course");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddCourse() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(getbtnAddCourse).click();
        Thread.sleep(2000);

        driver.findElement(getidName).sendKeys("TestCourse");
        driver.findElement(getidSemester).sendKeys("1");
        driver.findElement(getidDescription).sendKeys("Curso de prueba");
        driver.findElement(getidImage).sendKeys("https:testImage");
        driver.findElement(getidState).sendKeys("1");
        driver.findElement(getidDate).sendKeys("20200709");

        Thread.sleep(2000);
        driver.findElement(getbtnSubmit).click();

        //assertEquals(driver.findElement(getidName).getText(), "TestCourse");
        Thread.sleep(4000);
    }
}