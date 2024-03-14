package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewArrivalPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewArrivalPageTest extends TestBase {


     NewArrivalPage nap;
     HomePage hp;
    public NewArrivalPageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        nap  = new NewArrivalPage();
        hp= new HomePage();

    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("login test")
    @Feature("user is able to login")
    @Story("this enables user to login ")
    public void newArrivalTest()
    {
       String actual= nap.checkaddedtocartornot(prop.getProperty("UN"),prop.getProperty("password"));
        Assert.assertEquals(actual,hp.addeditemtocart.getText());


    }
}
