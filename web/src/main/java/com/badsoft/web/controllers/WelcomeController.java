package com.badsoft.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.badsoft.web.services.PasswordService;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    private final PasswordService passwordService;

    WelcomeController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/")
    public String welcome(@RequestParam(name = "query",
            required = false, defaultValue = "123456") String query, Model model) {
        logger.debug("Welcome to Bad's Password Hashing Highly Advanced System - Query : {}", query);

        model.addAttribute("query", query);
        model.addAttribute("hash", passwordService.hash(query));
        model.addAttribute("algorithm", passwordService.algorithm());

        return "index";
    }
}
