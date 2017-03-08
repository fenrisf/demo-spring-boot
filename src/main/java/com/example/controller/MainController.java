package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by albertomartinez on 8/03/17.
 */
public interface MainController {
    String getHelloWold(String name);
}
