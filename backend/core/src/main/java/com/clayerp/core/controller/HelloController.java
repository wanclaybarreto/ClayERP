package com.clayerp.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("api/hello")
    public String hello() {
        return "ClayERP API está rodando corretamente!";
    }

}
