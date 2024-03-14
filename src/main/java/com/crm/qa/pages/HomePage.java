package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
 public String HomePageTitle="Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='ctl00_lnkbtnLogout']")
    WebElement logoutbutton;

    //a[text()='Change Password']
    @FindBy(xpath = "//a[text()='Change Password']")
    WebElement changepassword;




    @FindBy(xpath = "//span[@id='ctl00_lblUser']")
    WebElement accountbutton;

    @FindBy(xpath = "(//a[text()='New Arrivals'])[1]")
    WebElement newArriaval;





    @FindBy(xpath = "(//span[@class='itemcount'])[1]")
    WebElement cartbutton;

    @FindBy(xpath = "//label[@id='ctl00_phBody_BookCart_lvCart_ctrl0_lblProductTitle']")
   public WebElement addeditemtocart;

    public String homepage(String un, String pw)
    {
        LoginPage lp = new LoginPage();
        lp.email.sendKeys(un);
        lp.password.sendKeys(pw);
        lp.loginbutton.click();
        return driver.getTitle();
    }
}
