package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Listeners(com.crm.qa.listener.Listenner.class)
public class LoginPageTest extends TestBase {

    TestUtil tu;
    LoginPage lp;
     public LoginPageTest()
     {
         super();
     }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
       lp  = new LoginPage();
       tu= new TestUtil();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("login test")
    @Feature("user is able to login")
    @Story("this enables user to login ")
    public void logintest() throws InterruptedException {
         log.info("LoginTest Method Running...");
       lp.login(prop.getProperty("UN"),prop.getProperty("password"));
    }

    @DataProvider
    public Object[][] getLoginTestData(){
        Object[][] data = tu.getTestData("login");
        return data;
    }

    @Test(dataProvider = "getLoginTestData" ,priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("login test")
    @Feature("user is able to login")
    @Story("this enables user to login ")
    public void multiplelogin(String email , String pass) throws InterruptedException {
        log.info("LoginTest Method Running...");
        lp.loginmultiple(email,pass);

    }


    @AfterMethod()
    public void teardown()
    {
        driver.quit();
    }


}
