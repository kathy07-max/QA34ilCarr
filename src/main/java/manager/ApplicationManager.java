package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;

    UserHelper userHelper;
    HelperCar car;
    HelperSearch search;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public void init(){
        if(browser.equals(Browser.CHROME.browserName())){
            wd=new ChromeDriver();
        }else if(browser.equals(Browser.EDGE.browserName())){
            wd = new EdgeDriver();
        }

        WebDriverListener listener = new MyListener();
        wd = new EventFiringDecorator(listener).decorate(wd);
        logger.info("All tests run in chrome browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://ilcarro-1578153671498.web.app/");
        logger.info("Current Url___>"+wd.getCurrentUrl());
        userHelper = new UserHelper(wd);
        car = new HelperCar(wd);
        search = new HelperSearch(wd);
    }
    public void stop(){
        wd.quit();    }

    public HelperSearch search() {
        return search;
    }

    public UserHelper getUserHelper() {

        return userHelper;
    }

    public HelperCar car() {
        return car;
    }
}
