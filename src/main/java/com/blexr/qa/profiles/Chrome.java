package com.blexr.qa.profiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Profile({ "chrome "})
@Component
@Configuration
public class Chrome extends Default {

    public static Logger log = LogManager.getLogger(Chrome.class);

    @Resource(name="wdm.chrome.version")
    private String version;

    @Bean
    public WebDriver driver()
    {
        WebDriver result;
        try
        {
            WebDriverManager.chromedriver().version(version).setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--accept-insecure-certs");
            options.addArguments("--enable-javascript");
            result = new ChromeDriver(options);
            currentDriver = result;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Chrome profile failed to start", e);
        }

        return result;
    }

}
