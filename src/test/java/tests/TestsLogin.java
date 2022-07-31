package tests;

import manager.MyDataProvider;
import models.User;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestsLogin extends BaseTests{

    @BeforeMethod (alwaysRun = true)
    public void preCondition(){
        if(appManager.getUserHelper().isLogged())
        {
            appManager.getUserHelper().logout();
            logger.info("Test start with logout");
        }
    }
    @Test(dataProvider = "dataLogin",dataProviderClass = MyDataProvider.class)
    public void loginSuccess(String email, String password){
        logger.info("Test start with email: "+email+" and password:"+password);
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm(email,password);
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getUserHelper().getMessage(),"Logged in");
        logger.info("Test passed");
    }
    @Test(dataProvider = "loginCSV",dataProviderClass = MyDataProvider.class)
    public void loginSuccessDP(User user){
        logger.info("Test start with email: "+user.getEmail()+" and password:"+user.getPassword());
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm(user);
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getUserHelper().getMessage(),"Logged in");
        logger.info("Test passed");
    }
    @Test (groups = {"web"})
    public void loginSuccess2(){
        appManager.getUserHelper().openLoginForm();
        appManager.getUserHelper().fillLoginForm("katermax07@mail.ru","Rr020985$");
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getUserHelper().getMessage(),"Logged in");
    }
@AfterMethod (alwaysRun = true)
    public void postCondition(){
    appManager.getUserHelper().clickOk();
}


}

