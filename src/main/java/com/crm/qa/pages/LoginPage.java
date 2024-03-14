package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    // page factory OR
    @FindBy(xpath = "//input[@name='ctl00$phBody$SignIn$txtEmail']")
    WebElement email;

    @FindBy(xpath = "//input[@name='ctl00$phBody$SignIn$txtPassword']")
    WebElement password;

    @FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
    WebElement loginbutton;

    @FindBy(xpath = "//label[@id='ctl00_phBody_SignIn_lblemailmsg']")
    WebElement invalidImailmsg;



    public void login(String un,String pwd)  {
        email.sendKeys(un);
        password.sendKeys(pwd);
        loginbutton.click();



    }

    public void loginmultiple(String mail,String pass) throws InterruptedException {

        email.sendKeys(mail);
        password.sendKeys(pass);
        //forgetPassword.click();
        loginbutton.click();
        Thread.sleep(3000);
        invalidImailmsg.isDisplayed();


    }
}

