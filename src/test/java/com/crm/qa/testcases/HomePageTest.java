package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage hp;
    public HomePageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        hp  = new HomePage();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("login test")
    @Feature("user is able to login")
    @Story("this enables user to login ")
    public void homepagetitle() throws InterruptedException {
      String actualtitle=  hp.homepage(prop.getProperty("UN"),prop.getProperty("password"));
         System.out.println(actualtitle);
        Assert.assertEquals(actualtitle,hp.HomePageTitle);
    }
}
