package com.blexr.qa.profiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Profile({ "default "})
@Component
@Configuration
public class Default extends SpringBeanAutowiringSupport
{
    public static Logger log = LogManager.getLogger(Default.class);

    protected WebDriver currentDriver;

    @PostConstruct
    public void init()
    {}


    @Bean
    public WebDriver driver()
    {
        log.error("Attempt to run with no target profile selected. Please use 'spring.profiles.active' at runtime.");
        return null;
    }

}
