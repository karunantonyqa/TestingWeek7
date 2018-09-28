package com.qa.SpringTutorial;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.qa.controller")

public class WebConfig {

}
