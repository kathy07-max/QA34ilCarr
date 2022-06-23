package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestsLogin extends BaseTests{

    @Test
    public void loginSuccess(){
        openLoginForm();
        fillLoginForm("katermax07@mail.ru","Rr020985$");
        submitLogin();
        assertMethod(By.xpath("//*[text()='Logged in success']"));

    }

    @Test
    public void negativeLoginInvalidPassword(){
        openLoginForm();
        fillLoginForm("katermax06@mail.ru","Rr020985$");
        submitLogin();
        assertMethod(By.xpath("//*[text()='Wrong email or password']"));
    }
}
