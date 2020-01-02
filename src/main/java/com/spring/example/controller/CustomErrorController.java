/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.example.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Tanawit Aeabsakul
 */
public class CustomErrorController implements ErrorController {
    
    private static final String PATH = "/error";
    
    @GetMapping(PATH)
    public String error() {
        return "Error haven";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
    
}
