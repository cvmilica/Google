package com.google.pages;

import com.google.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    /**
     * Make sure to extend BasePage to all other Pages
     */

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[normalize-space()='About']")
    public WebElement about;

    @FindBy(xpath = "//a[normalize-space()='Store']")
    public WebElement store;

    @FindBy(xpath = "//a[@data-pid='2']")
    public WebElement images;

    @FindBy(xpath = "//a[@aria-label='Gmail (opens a new tab)']")
    public WebElement gmail;

    @FindBy(xpath = "//a[normalize-space()='Privacy']")
    public WebElement privacy;

    @FindBy(xpath = "//a[normalize-space()='Privacy']")
    public WebElement terms;

    @FindBy(xpath = "//div[@class='ayzqOc pHiOh']")
    public WebElement settings;

}
