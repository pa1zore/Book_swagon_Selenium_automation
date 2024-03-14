package com.crm.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.qa.util.TestUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public  static  Logger log = Logger.getLogger(TestBase.class);
 public static WebDriver driver;
  public static Properties prop;
 public  ExtentReports extent= new ExtentReports() ;
 public ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\Lenovo\\Desktop\\New folder (2)\\RestAssured\\freecrmtestautomation\\ExtentReport\\ExtentReport.html");
   public TestBase()
    {
       try {
           prop=new Properties();
           FileInputStream ip = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\New folder (2)\\RestAssured\\freecrmtestautomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
       prop.load(ip);
       }
       catch (FileNotFoundException e)
       {
           e.printStackTrace();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }
    public  void initialization()  {
        log.info("Browser name:"+prop.getProperty("browser"));

      String browserName=  prop.getProperty("browser");

      if(browserName.equals("chrome"))
      {
          driver = new ChromeDriver();
          log.info("Application URL :"+ prop.getProperty("browser"));
      } else if (browserName.equals("ME")) {
          driver = new EdgeDriver();

      }
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      driver.get(prop.getProperty("URL"));


    }


}
