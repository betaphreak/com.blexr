package com.blexr.qa.pages.vegas;

import com.blexr.qa.pages.BasePage;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// instance of this class handles landing page for https://www.vegasslotsonline.com/real-money/
public class LandingPage extends BasePage {
    private static final Logger log = LogManager.getLogger(LandingPage.class);

    @FindAll({@FindBy(xpath = "//div[@class='col-md-9 bottom-menu']/ul/li/a")})
    private List<WebElement> footer;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        try {
            PageFactory.initElements(driver, this);
            waitForLoad();
            scrollTo(footer.get(0));
            } catch (WebDriverException e) {
            throw new RuntimeException("Failed to initialize landing page", e);
        }
    }

    public List<String> getFooter()
    {
        return footer != null ?
                footer.stream().map(WebElement::getText).collect(Collectors.toList()) : Collections.emptyList();
    }

    public ImmutablePair<LandingPage, String> partialUrlFromLinkTest(String linkText)
    {
        String url = "";
        waitForLoad();
        List<WebElement> links = getDriver().findElements(By.linkText(linkText));
        if (links.size() > 0)  // at least one hyperlink should exist in this list if the element is present
        {
            WebElement elem = links.get(0);
            scrollTo(elem);
            try
            {
                elem.click();
                RelativePage page = new RelativePage(getDriver());
                url = page.getUrl();
                return new ImmutablePair<>(page.back(), url);
            }
            catch (ElementClickInterceptedException e) // if other element would receive the click
            {
                return new ImmutablePair<>(this, elem.getAttribute("href"));
            }
        }
        return new ImmutablePair<>(this, "");
    }
}




