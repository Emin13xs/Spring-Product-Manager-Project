package org.example.springtest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MoneyController {

    @GetMapping
    public String test(){
        return "Testing";

    }
}
