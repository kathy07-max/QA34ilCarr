package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests {
    @BeforeMethod
    public void preCondition() {
        if (appManager.getUserHelper().isLogged()) {
            appManager.getUserHelper().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user1 = new User().setName("Mona").setLastName("Lisa").setEmail("monalisa"+i+"@gmail.com").setPassword("020985$Max");
        appManager.getUserHelper().openRegistrationForm();
        appManager.getUserHelper().fillRegistrationForm(user1);
        appManager.getUserHelper().checkPolicyXY();
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getUserHelper().getMessage(), "Registered");

    }

    @Test(dataProvider = "dataRegistration",dataProviderClass = MyDataProvider.class)
    public void registrationSuccess2(User user){

        appManager.getUserHelper().openRegistrationForm();
        appManager.getUserHelper().fillRegistrationForm(user);
        appManager.getUserHelper().checkPolicyXY();
        appManager.getUserHelper().submit();
        Assert.assertEquals(appManager.getUserHelper().getMessage(), "Registered");

    }
    @Test
    public void registrationWrongPasswordFormat(){
        User user = new User().setName("Zoa").setLastName("Snoww").setEmail("zoa@gmail.com").setPassword("Zoa");
        appManager.getUserHelper().openRegistrationForm();
        appManager.getUserHelper().fillRegistrationForm(user);
        appManager.getUserHelper().checkPolicyXY();
        Assert.assertTrue(appManager.getUserHelper().isErrorPasswordFormatDisplayed());
        Assert.assertTrue(appManager.getUserHelper().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(appManager.getUserHelper().isYallaButtoNotActive());
    }
    @AfterMethod
    public void postCondition(){
        appManager.getUserHelper().clickOk();
    }
}
