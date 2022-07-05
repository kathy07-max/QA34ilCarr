package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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
        type(By.xpath("//input[@id='password']"),password);
    }



    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//*[text()=' Logout ']"));
        return list.size()>0;
    }

    public void logout() {
       wd.findElement(By.xpath("//*[text()=' Logout ']")).click();

    }

    public void checkPolicyXY(){
        //click(By.cssSelector("label[for='terms-of-use']"));
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOf = rect.getWidth()/2;
        int yOf = rect.getHeight()/2;
        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-xOf, -yOf).click().release().perform();

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
        click(By.xpath("//button[text()='Ok']"));
    }
}
