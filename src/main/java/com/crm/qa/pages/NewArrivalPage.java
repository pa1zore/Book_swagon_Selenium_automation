package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArrivalPage extends TestBase {


    public NewArrivalPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//img[@class='card-img-top bklazy'])[1]")
    WebElement elonbook;

    @FindBy(xpath = "(//span[text()='Untitled Nonfiction PP'])[1]")
    WebElement texttobeadded;
    @FindBy(xpath = "//a[@id='btnAddtocart']")
    WebElement addtocart;

    public String checkaddedtocartornot(String un , String pass)
    {
        LoginPage lp = new LoginPage();
        HomePage hp = new HomePage();
        lp.email.sendKeys(un);
        lp.password.sendKeys(pass);
        lp.loginbutton.click();
        hp.newArriaval.click();
        elonbook.click();
        addtocart.click();
        String textofproduct=texttobeadded.getText();
        hp.cartbutton.click();

     return textofproduct;
    }
}
