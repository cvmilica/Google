package com.google.pages;

import com.google.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends BasePage{

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@aria-label='Search by voice']")
    public WebElement searchByVoice;

    @FindBy(xpath = "//div[@aria-label='Search by image']")
    public WebElement searchByImage;


}
