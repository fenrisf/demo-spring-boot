package com.example.controller.impl;

import com.example.controller.MainController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by albertomartinez on 8/03/17.
 */
@RestController
public class MainControllerImpl implements MainController {
    @Override
    @RequestMapping(value = "/wellcome/{nombre}", method = RequestMethod.GET)
    public String getHelloWold(@PathVariable(name="nombre") String name) {
        return "Wellcome " + name;
    }
}
