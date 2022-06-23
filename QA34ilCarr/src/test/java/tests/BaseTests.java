package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests {

    WebDriver wd;

    @BeforeMethod
    public void preConditions(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-1578153671498.web.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void openLoginForm(){
        wd.findElement(By.xpath("//a[text()=' Log in ']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
    }

    public void type(By locator,String text) {
        if (text != null) {
            WebElement textBox = wd.findElement(locator);
            textBox.click();
            textBox.clear();
            textBox.sendKeys(text);
        }
    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }
    public boolean assertMethod(By locator){
        return  wd.findElement(locator).isDisplayed();

    }
}
