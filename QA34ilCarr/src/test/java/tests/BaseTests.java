package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTests {
    Logger logger = LoggerFactory.getLogger(BaseTests.class);
   protected static ApplicationManager appManager = new ApplicationManager();

   @BeforeMethod
   public void startLogger(Method m){
       logger.info("Started method with name: " + m);
   }
    @BeforeSuite
    public void setUp(){
        appManager.init();
       }
  // @AfterSuite
   ///public void tearDown() {
     //appManager.stop();
    //}
}
