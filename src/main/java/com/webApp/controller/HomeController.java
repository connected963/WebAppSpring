package com.webApp.controller;

import com.webApp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by connected on 2/6/17.
 */
@RestController
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    private HomeService homeService;

    @Autowired
    public HomeController(final HomeService homeService) {
        this.homeService = homeService;
    }

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world";
    }

    @RequestMapping("/whoIsTheBoss")
    public String whoIsTheBoss() {
        return homeService.getTheBoss();
    }

    @RequestMapping("/giveMeYourName")
    public String myNameIs() {
        return appName;
    }

    @RequestMapping("/giveMeYourConfigurationClass")
    public String giveMeYourConfigurationClass() {
        return homeService.getAppNameFromSpringConfigurations();
    }
}