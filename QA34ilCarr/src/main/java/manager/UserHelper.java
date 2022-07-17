package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        wd.findElement(By.xpath("//a[text()=' Log in ']")).click();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email);
        takeScreenShots("C:\\Users\\97254\\DocQA34\\GitHub\\QA34ilCarr\\QA34ilCarr\\src\\test\\screenshots\\screen1.jpeg");
        type(By.xpath("//input[@id='password']"),password);

        takeScreenShots("C:\\Users\\97254\\DocQA34\\GitHub\\QA34ilCarr\\QA34ilCarr\\src\\test\\screenshots\\screen1.jpeg");
    }

    public void fillLoginForm(User user){
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }
    public boolean isLogged() {

        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
       click(By.xpath("//a[text()=' Logout ']"));

    }

    public void checkPolicyXY(){
        //click(By.cssSelector("label[for='terms-of-use']"));
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOf = rect.getWidth()/2;
        int yOf = rect.getHeight()/2;
        Actions actions = new Actions(wd);
        actions.moveToElement(label, -xOf, 0).click().release().perform();

    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user1) {
        type(By.id("name"),user1.getName());
        type(By.id("lastName"), user1.getLastName());
        type(By.id("email"), user1.getEmail());
        type(By.id("password"), user1.getPassword());

    }

    public void clickOk() {
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
        click(By.xpath("//button[text()='Ok']"));
    }
    public String getMessage() {
        pause(2000);
        new WebDriverWait(wd,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        String message = wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        logger.info("Message is: "+ message);
        return message;
    }

    public boolean isErrorPasswordFormatDisplayed() {
        Boolean lastChild = new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:last-child")),"Password must contain 1 uppercase letter, 1 lowercase letter and one number"));

        return lastChild;
    }

    public boolean isErrorPasswordSizeDisplayed() {
       return new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:first-child")),"Password must contain minimum 8 symbols"));
    }

    public boolean isYallaButtoNotActive() {
        boolean disabled = isElementPresent(By.cssSelector("button[disabled]"));

        boolean enabled = wd.findElement(By.cssSelector("[type=submit]")).isEnabled();
        return disabled&&!enabled;
    }
    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOk();
    }
}
