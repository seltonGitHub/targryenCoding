package com.example.demo.controller;

import com.example.demo.model.PO.MagicCube;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SeltonUserController {

    @PostMapping("/register")
    public String loginVefify() {
        System.out.println("SeltonUserController.loginVefify");
        return null;
    }

}
