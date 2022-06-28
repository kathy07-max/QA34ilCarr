package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        wd.findElement(By.xpath("//a[text()=' Log in ']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//*[text()=' Logout ']"));
        return list.size()>0;
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }
}
