package com.blexr.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// instance of this class handles landing page for https://www.vegasslotsonline.com/real-money/
public class LandingPage extends PageFactory {
    private static final Logger log = LogManager.getLogger(LandingPage.class);
    private WebDriver currentDriver;

    @FindAll({@FindBy(xpath = "//div[@class='col-md-9 bottom-menu']/ul/li/a")})
    private List<WebElement> footer;

    protected void waitForLoad() {
        ExpectedCondition<Boolean> loaded = driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(currentDriver, 10);
        wait.until(loaded);
    }

    public LandingPage(WebDriver driver) {
        try {
            currentDriver = driver;
            PageFactory.initElements(driver, this);
            waitForLoad();
            ((JavascriptExecutor) currentDriver).executeScript("arguments[0].scrollIntoView();", footer.get(0));
        } catch (WebDriverException e) {
            log.error("Failed to initialize landing page", e);
        }
    }

    public List<String> getFooter()
    {
        return footer != null ?
                footer.stream().map(WebElement::getText).collect(Collectors.toList()) : Collections.emptyList();
    }
}




