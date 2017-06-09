package com.ssh.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "main")
public class MainController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(MainController.class);

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(@RequestParam Map<String, String> params) {
        LOGGER.info("home");
        return "home";
    }
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(@RequestParam Map<String, String> params) {
        LOGGER.info("index");
        String username = params.get("username");
        LOGGER.info(username);
        return "index";
    }
}
