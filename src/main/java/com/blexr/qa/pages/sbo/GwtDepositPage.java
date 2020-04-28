package com.blexr.qa.pages.sbo;

import com.blexr.qa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GwtDepositPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'50 -')]")
    private WebElement selectMidOption;

    public GwtDepositPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GwtBonusPage selectMidDeposit()
    {
        selectMidOption.click();
        return new GwtBonusPage(getDriver());
    }

}
