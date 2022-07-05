package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests {
    @BeforeTest
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
//        Assert.assertEquals(appManager.getMessage(), "Registered");
//        appManager.getUserHelper().clickOk();

    }
}
