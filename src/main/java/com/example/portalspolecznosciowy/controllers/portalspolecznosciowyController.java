package com.example.portalspolecznosciowy.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class portalspolecznosciowyController {

    @GetMapping("/")
    public String indexrender() {
        return "index";
    }
}
