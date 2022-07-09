package tests;

import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends BaseTests{

    @BeforeMethod
    public void preCondition(){

    }

    @Test
    private void addNewCarSuccess(){
        Car car = Car.builder().address("Haifa, Israel").make("BMW").model("M7").year("2019").engine("2.5").fuel("Petrol").gear("AT").wD("AWD").doors("5").seats("4").clasS("C")
                .fuelConsumption("6.5").carRegNumber("111-334-765").price("65").distanceIncluded("700").features("features").about("very nice car").build();

        appManager.car().openCarForm();
        appManager.car().fillCarForm(car);
        appManager.car().attachPhoto();
        appManager.car().submit();
    }
}
