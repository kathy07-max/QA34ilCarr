package tests;

import org.testng.annotations.Test;

public class TestsLogin extends BaseTests{

    @Test
    public void loginSuccess(){
        openLoginForm();
        fillLoginForm("katermax07@mail.ru","Rr020985$");
        submitLogin();
    }

    @Test
    public void negativeLoginInvalidPassword(){
        openLoginForm();
        fillLoginForm("katermax06@mail.ru","Rr020985$");
        submitLogin();
    }
}
