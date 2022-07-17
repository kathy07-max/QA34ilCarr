package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTests {
    @Test
    public void searchCurrentMonth(){
        appManager.search().searchCurrentMonth("Tel Aviv", "7/28/2022", "7/27/2022");
        appManager.search().submit();
      //  Assert.assertTrue(appManager.search().isListOfCarsAppeared);
    }

    @Test
    public void searchCurrentYear(){
        appManager.search().searchCurrentYear("Tel Aviv", "8/10/2022", "10/20/2022");
        appManager.search().submit();
    }
}
