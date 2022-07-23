package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{


    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentMonth(dataFrom, dataTo);
    }

    private void selectPeriodCurrentMonth(String dataFrom, String dataTo) {
        clearDates();
        String[] from = dataFrom.split("/");
        String locator = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locator));
        String[] to = dataTo.split("/");
        String locator2 = String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        pause(500);
        click(By.cssSelector(".pac-item"));
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentYear(dataFrom, dataTo);
    }

    private void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        String dataNow = "7/20/2022";
        String[] now = dataNow.split("/");
        String[] from = dataFrom.split("/");
        String[] to = dataTo.split("/");
        clearDates();

        if(!now[0].equals(from[0])){
            int count = Integer.parseInt(from[0])-Integer.parseInt(now[0]);
            clickByNextMonth(count);
        }
        String locator = String.format("//div[text()=' %s ']",from[1]);
        click(By.xpath(locator));

        if(Integer.parseInt(from[0])!=Integer.parseInt(to[0])){
            int count = Integer.parseInt(to[0])-Integer.parseInt(from[0]);
            clickByNextMonth(count);
        }
        String locator1 = String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator1));

    }

    private void clickByNextMonth(int count) {
        for(int i = 0;i < count; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".cars-container.ng-star-inserted"));
    }

    public boolean isPageResultAppeared() {
        String currentURL = wd.getCurrentUrl();
        System.out.println(currentURL);
        return currentURL.startsWith("https://ilcarro-1578153671498.web.app/search/results");
    }

    public void searchCurrentYearLocalDate(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        clearDates();

        if(now.getMonthValue()!=from.getMonthValue()){
            int count = from.getMonthValue()-now.getMonthValue();
            clickByNextMonth(count);
        }
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        if(from.getMonthValue()!=to.getMonthValue()){
            int count = to.getMonthValue()-from.getMonthValue();
            clickByNextMonth(count);
        }
        locator  = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }

    private void clearDates() {
        wd.findElement(By.id("city")).sendKeys(Keys.TAB);
        wd.findElement(By.id("dates")).sendKeys(Keys.DELETE);
        click(By.id("dates"));
    }
    private void clearDates2() {

        wd.findElement(By.id("city")).sendKeys(Keys.TAB);
        wd.findElement(By.id("dates")).sendKeys(Keys.DELETE);
        click(By.id("dates"));
    }
    public void searchPeriodInPast(String city, String data){
        typeCity(city);
        wd.findElement(By.id("city")).sendKeys(Keys.TAB);
        wd.findElement(By.id("dates")).sendKeys(Keys.DELETE);
        type(By.id("dates"),data);
    }

    public void searchAnyPeriodLocalDate(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        clearDates();
        int diffYear;
        int diffMonth;

        diffYear = from.getYear()-now.getYear();
        if(diffYear==0){
            diffMonth = from.getMonthValue()-now.getMonthValue();
        }
        else {
            diffMonth= 12-now.getMonthValue()+from.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text() = ' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        diffYear = to.getYear()- from.getYear();
        if(diffYear==0){
            diffMonth = to.getMonthValue()-from.getMonthValue();
        } else {
            diffMonth = 12-from.getMonthValue()+to.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        locator = String.format("//div[text() = ' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }

    public void returnToSearch() {
        pause(1000);
        click(By.id("0"));
    }

    public boolean isErrorDatesDisplayed() {
        return new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("div[class='ng-star-inserted']")),"You can't pick date before today"));
    }
}
