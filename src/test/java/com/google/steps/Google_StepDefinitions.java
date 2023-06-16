package com.google.steps;

import com.google.pages.GoogleSearchPage;
import com.google.utility.BrowserUtil;
import com.google.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("the user has already navigated to the Google search page")
    public void the_user_has_already_navigated_to_the_google_search_page() {
        // Done in Hooks class
    }

    @Then("the user should see that the title is {string}")
    public void the_user_should_see_that_the_title_is(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @When("the user searches for {string}")
    public void the_user_searches_for(String word) {
        googleSearchPage.searchBox.sendKeys(word + Keys.ENTER);
    }

    @Then("the user should see {string} in the title")
    public void the_user_should_see_in_the_title(String word) {

        BrowserUtil.verifyTitle( word + " - Google Search");
        // Utility method verifyTitle
    }


}
