package com.blexr.qa.pages.sbo;

import com.blexr.qa.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SboPage extends BasePage {
    private static final Logger log = LogManager.getLogger(SboPage.class);

    @FindBy(xpath = "//div[@class='kgw-header for-picker']//span[1]")
    private WebElement bookieSelector;

    @FindBy(xpath = "//div[@class='close-wizard close-int']")
    private WebElement gwtCloseButton;

    public SboPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitForLoad();
    }

    public GwtDevicePage bookieSelect()
    {
        bookieSelector.click();
        return new GwtDevicePage(getDriver());
    }

    public boolean hasFailedGwt()
    {
        return gwtCloseButton == null;
    }


}
