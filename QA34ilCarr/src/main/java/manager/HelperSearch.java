package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentMonth(dataFrom, dataTo);
    }

    private void selectPeriodCurrentMonth(String dataFrom, String dataTo) {
        click(By.id("dates"));
        String[] from = dataFrom.split("/");
        String locator = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locator));
        String[] to = dataTo.split("/");
        String locator2 = String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentYear(dataFrom, dataTo);
    }

    private void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        String now = "7/17/2022";
    }
}
