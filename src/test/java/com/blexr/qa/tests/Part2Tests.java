package com.blexr.qa.tests;

import com.blexr.qa.pages.LandingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Part2Tests {

    @Resource
    private WebDriver driver;

    @Before
    public void before()
    {}

    @Test
    public void Task21Test()
    {
        List<String> expected = Arrays.asList("Contact Us", "Responsible Gambling", "Fairness and Testing",
                "Licensing Bodies and Regulators", "Sitemap", "Privacy Policy");

        driver.navigate().to("https://www.vegasslotsonline.com/real-money/");
        LandingPage landingPage = new LandingPage(driver);

        assertThat(landingPage.getFooter(), is(expected));
    }

    @After
    public void after()
    {}

}
