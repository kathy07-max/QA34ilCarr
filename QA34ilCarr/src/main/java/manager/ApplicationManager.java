package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    HelperCar car;
    public void init(){
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://ilcarro-1578153671498.web.app/");
        userHelper = new UserHelper(wd);
        car = new HelperCar(wd);
    }
    public void stop(){
        wd.quit();    }

    public UserHelper getUserHelper() {

        return userHelper;
    }

    public HelperCar car() {
        return car;
    }
}
