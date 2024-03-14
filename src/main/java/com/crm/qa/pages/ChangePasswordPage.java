package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends TestBase {
    public ChangePasswordPage()
    {
        PageFactory.initElements(driver,this);
    }

    //input[@id='ctl00_phBody_ChangePassword_txtCurPwd']

    @FindBy(xpath = "//input[@id='ctl00_phBody_ChangePassword_txtCurPwd']")
    WebElement oldpassword;

    @FindBy(xpath = "//input[@id='ctl00_phBody_ChangePassword_txtNewPassword']")
    WebElement newpassword;

    @FindBy(xpath = "ctl00_phBody_ChangePassword_txtConfirmPwd")
    WebElement confirmpassword;

    //a[@id='ctl00_phBody_ChangePassword_imgSubmit']

    @FindBy(xpath = "//a[@id='ctl00_phBody_ChangePassword_imgSubmit']")
    WebElement changepasswordbutton;

    //span[@id='ctl00_phBody_ChangePassword_lblmsg']

    @FindBy(xpath = "//span[@id='ctl00_phBody_ChangePassword_lblmsg']")
    WebElement successfullychangemsg;


    public boolean Changepassword(String un,String pwd) throws InterruptedException {
       LoginPage lp=new LoginPage();
       HomePage hp = new HomePage();
       lp.email.sendKeys(un);
       lp. password.sendKeys(pwd);
        lp.loginbutton.click();
        hp.changepassword.click();
        oldpassword.sendKeys("PASS@123");
        newpassword.sendKeys("PAss@123");
        confirmpassword.sendKeys("PAss@123");
        Thread.sleep(3000);
        return successfullychangemsg.isDisplayed();



    }

}
