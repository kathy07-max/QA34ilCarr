package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HelperBase {
    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator, String text) {
        if (text != null) {
            WebElement textBox = wd.findElement(locator);
            textBox.click();
            textBox.clear();
            textBox.sendKeys(text);
        }
    }
    public void click(By locator){
        wd.findElement(locator).click();
    }
    public String getMessage() {
        // pause
        //pause(2000);
        //wait container
        new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));

        //String  message = wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        return wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
    }
    public void submit(){
        new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//button[@type='submit']"))));
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void takeScreenShots(String pathToFile){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screen = new File(pathToFile);
        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
