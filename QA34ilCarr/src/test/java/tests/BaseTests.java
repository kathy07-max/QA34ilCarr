package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTests {

   protected static ApplicationManager appManager = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        appManager.init();
       }
  // @AfterSuite
   ///public void tearDown() {
     //appManager.stop();
    //}
}
