package com.webApp.service;

import com.webApp.configurations.SpringConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by connected on 2/6/17.
 */
@Service
public class HomeService {

    private final SpringConfigurations springConfigurations;

    @Autowired
    public HomeService(final SpringConfigurations springConfigurations) {
        this.springConfigurations = springConfigurations;
    }

    public String getAppNameFromSpringConfigurations() {
        return this.springConfigurations.toString();
    }

    public String getTheBoss() {
        return this.springConfigurations.getBoss();
    }
}
