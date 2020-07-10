package cr.ac.ucr.spa.Selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import  org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {
    private WebDriver driver;
    By getbtnAddProfessor = By.id("btnAddProfessor");

    By getidUsername = By.id("idUsername");
    By getidDegree = By.id("idDegree");
    By getidPassword = By.id("idPassword");
    By getidInterest = By.id("idInterest");
    By getidEmail = By.id("idEmail");
    By getidProvince = By.id("idProvince");
    By getidCanton = By.id("idCanton");
    By getidDistrict = By.id("idDistrict");

    By getbtnSubmit = By.id("btnSubmit");


    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nee\\Documents\\UCR\\SPA_IE_Angular\\Selenium\\GeckoDriver\\geckodriver.exe");
        driver=new FirefoxDriver();
        //driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/professor-list");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @Test
    public void testProfessor() throws InterruptedException {
        driver.findElement(getbtnAddProfessor).click();
        Thread.sleep(2000);

        driver.findElement(getidUsername).sendKeys("Lyka");
        Thread.sleep(2000);
        driver.findElement(getidDegree).sendKeys("Doctor");
        Thread.sleep(2000);
        driver.findElement(getidPassword).sendKeys("123");
        Thread.sleep(2000);
        driver.findElement(getidInterest).sendKeys("Bailar");
        Thread.sleep(2000);
        driver.findElement(getidEmail).sendKeys("lyka@mail.com");

        Select drpProvince = new Select(driver.findElement(getidProvince));
        drpProvince.selectByVisibleText("Cartago");

        Thread.sleep(4000);
        Thread.sleep(4000);
        Select drpCanton = new Select(driver.findElement(getidCanton));
        drpCanton.selectByVisibleText("Paraíso");

        Thread.sleep(4000);
        Thread.sleep(4000);
        Select drpDistrict = new Select(driver.findElement(getidDistrict));
        drpDistrict.selectByVisibleText("Paraíso");

        Thread.sleep(2000);
        driver.findElement(getbtnSubmit).click();
        Thread.sleep(4000);
    }
}