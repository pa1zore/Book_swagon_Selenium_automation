package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ChangePasswordPage;
import com.crm.qa.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {

    ChangePasswordPage cpp;
    public ChangePasswordTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        cpp  = new ChangePasswordPage();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("login test")
    @Feature("user is able to login")
    @Story("this enables user to login ")
    public void changepasswordtest() throws InterruptedException {
        boolean actulstatus=cpp.Changepassword(prop.getProperty("UN"),prop.getProperty("password"));
        Assert.assertEquals(actulstatus,true);
    }
}
