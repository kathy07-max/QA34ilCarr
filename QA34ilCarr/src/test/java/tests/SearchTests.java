package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends BaseTests {
    @Test
    public void searchCurrentMonth(){
        appManager.search().searchCurrentMonth("Tel Aviv", "7/28/2022", "7/27/2022");
        appManager.search().submit();
        Assert.assertTrue(appManager.search().isListOfCarsAppeared());
        Assert.assertTrue(appManager.search().isPageResultAppeared());
    }
    @Test
    public void searchPeriodPast(){
        appManager.search().searchPeriodInPast("Tel-Aviv","5/4/2022-5/10/2022");
        Assert.assertTrue(appManager.search().isErrorDatesDisplayed());
        Assert.assertTrue(appManager.getUserHelper().isYallaButtoNotActive());

    }

    @Test
    public void searchCurrentYear(){
        appManager.search().searchCurrentYear("Haifa", "8/10/2022", "10/20/2022");
        appManager.search().submit();
        Assert.assertTrue(appManager.search().isListOfCarsAppeared());
        Assert.assertTrue(appManager.search().isPageResultAppeared());
    }

    @Test ()
    public void searchCurrentYearLocalDate(){
        appManager.search().searchCurrentYearLocalDate("Haifa", "8/10/2022", "10/20/2022");
        appManager.search().submit();
        Assert.assertTrue(appManager.search().isListOfCarsAppeared());
        Assert.assertTrue(appManager.search().isPageResultAppeared());
    }

    @Test
    public void searchAnyPeriod(){
        appManager.search().searchAnyPeriodLocalDate("Haifa", "1/10/2023", "04/20/2023");
        appManager.search().submit();
        Assert.assertTrue(appManager.search().isListOfCarsAppeared());
    }

    @AfterMethod
    public void returnToSearch() {
        appManager.search().returnToSearch();
    }
}
