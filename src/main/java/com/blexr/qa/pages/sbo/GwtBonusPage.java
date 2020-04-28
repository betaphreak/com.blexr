package com.blexr.qa.pages.sbo;

import com.blexr.qa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class GwtBonusPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'YES')]")
    private WebElement selectYesBonus;

    public GwtBonusPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SboPage selectYes() throws InterruptedException {
        selectYesBonus.click();
        sleep(5000);
        return new SboPage(getDriver());
    }

}
