package com.blexr.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RelativePage extends BasePage
{
    public RelativePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LandingPage back()
    {
        getDriver().navigate().back();
        return new LandingPage(getDriver());
    }

    public String getUrl()
    {
        return getDriver().getCurrentUrl();
    }

}
