package com.blexr.qa.pages.sbo;

import com.blexr.qa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GwtDevicePage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Desktop')]")
    private WebElement selectDesktopDevice;

    public GwtDevicePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GwtDepositPage selectDesktop()
    {
        selectDesktopDevice.click();
        return new GwtDepositPage(getDriver());
    }



}
