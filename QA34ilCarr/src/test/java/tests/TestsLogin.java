package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestsLogin extends BaseTests{

    @BeforeMethod
    public void preCondition(){
        if(appManager.getUserHelper().isLogged())
        {
            appManager.getUserHelper().logout();
            logger.info("Test start with logout");
        }
    }
    @Test
    public void loginSuccess(){
        logger.info("Test start with email: 'katermax07@mail.ru' and password: 'Rr020985$'");
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("katermax07@mail.ru","Rr020985$");
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getUserHelper().getMessage(),"Logged in");
        logger.info("Test passed");
    }
    @Test
    public void loginSuccess2(){
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("katermax07@mail.ru","Rr020985$");
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getUserHelper().getMessage(),"Logged in");
    }
@AfterMethod
    public void postCondition(){
    appManager.getUserHelper().clickOk();
}
}
