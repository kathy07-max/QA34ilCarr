package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestsLogin extends BaseTests{

    @BeforeMethod
    public void preCondition(){
        if(appManager.getUserHelper().isLogged())
        {
            appManager.getUserHelper().logout();
        }
    }
    @Test
    public void loginSuccess(){
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("katermax07@mail.ru","Rr020985$");
        appManager.getUserHelper().submitLogin();
        appManager.getUserHelper().click(By.xpath("//*[@type='button']"));
    }

    @Test
    public void loginUnsuccessInvalidPassword(){
       appManager.getUserHelper().openLoginForm();
       appManager.getUserHelper().fillLoginForm("katermax06@mail.ru","Rr020985");
       appManager.getUserHelper().submitLogin();
    }
}
