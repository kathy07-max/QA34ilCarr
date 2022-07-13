package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCar extends BaseTests{

    @BeforeMethod
    public void preCondition(){
        if(!appManager.getUserHelper().isLogged()){
            appManager.getUserHelper().login(new User().setEmail("katermax07@mail.ru").setPassword("Rr020985$"));
        }

    }

    @Test
    private void addNewCarSuccess(){
        Random random = new Random();
        int i =random.nextInt(1000)+1000;

        Car car = Car.builder().address("Haifa, Israel").make("BMW").model("M7").year("2019").engine("2.5").fuel("Petrol").gear("AT").wD("AWD").doors("5").seats("4").clasS("C")
                .fuelConsumption("6.5").carRegNumber("111-334-765").price("65").distanceIncluded("700").features("features").about("very nice car").build();

        appManager.car().openCarForm();
        appManager.car().fillCarForm(car);
        appManager.car().attachPhoto("C:\\Users\\97254\\DocQA34\\GitHub\\QA34ilCarr\\QA34ilCarr\\auto1.jpeg");
        appManager.car().submit();
        Assert.assertEquals(appManager.car().getMessage(), "Car added");
    }

    @AfterMethod
    public void postCondition(){
        appManager.car().returnToHome();
    }
}
