package com.blexr.qa.tests;

import com.blexr.qa.pages.LandingPage;
import com.blexr.qa.pages.RelativePage;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Part2Tests {

    @Resource @SuppressWarnings("unused")
    private WebDriver driver;

    private LandingPage landingPage;

    @Before
    public void before()
    {
        driver.navigate().to("https://www.vegasslotsonline.com/real-money/");
        landingPage = new LandingPage(driver);
    }

    @Test
    public void Task21Test()
    {
        List<String> expected = Arrays.asList("Contact Us", "Responsible Gambling", "Fairness and Testing",
                "Licensing Bodies and Regulators", "Sitemap", "Privacy Policy");

        assertThat(landingPage.getFooter(), is(expected));
    }

    @Test
    public void Task22Test()
    {
        Map<String, String> checklist = new HashMap<>();
        checklist.put("live casino", "/live-dealer/");
        checklist.put("payment methods", "/deposit-methods/");
        checklist.put("all gambling games", "/table-games/");
        checklist.put("new games", "/new-online-slots/");
        checklist.put("all software providers you’ll find at online casinos", "/software-providers/");

        checklist.forEach((linkText, urlPart) -> {
            ImmutablePair<LandingPage, String> eval = landingPage.partialUrlFromLinkTest(linkText);
            assertThat(eval.getValue(), StringContains.containsString(urlPart));
            landingPage = eval.getKey();
        });
    }


}
