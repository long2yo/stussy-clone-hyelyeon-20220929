package com.stussy.stussyclonehyelyeon20220929.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
@Configuration
public class AccountPageController {

    @GetMapping("/login")
    public String login() {
//        try { Thread.sleep(2000);
//        } catch (InterruptedException e) {
//           throw new RuntimeException(e);
//        }

        return "account/login";
    }

    @GetMapping("/register")
    public String register() {
        return "account/register";
    }

}
