package com.daytona.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeController {

    private Logger logger=LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String home(
            @RequestParam(defaultValue = "default",required = false) String value
    ){
       // System.out.println("Hello, you are in home");

        logger.info("Hello from logger {}",value);
        logger.error("Hello from logger {}",value);
        logger.warn("Hello from logger {}",value);
        logger.debug("Hello from logger {}",value);
        logger.trace("Hello from logger {}",value);
        return "Hello from spring...";
    }
}
