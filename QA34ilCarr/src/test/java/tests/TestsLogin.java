package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestsLogin extends BaseTests{

    @BeforeTest
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
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getMessage(),"");
        appManager.getUserHelper().click(By.xpath("//*[@type='button']"));

    }

    @Test
    public void loginSuccessInvalidPassword(){
       appManager.getUserHelper().openLoginForm();
       appManager.getUserHelper().fillLoginForm("katermax07@mail.ru","Rr020985");
       appManager.getUserHelper().submit();
    }
}
