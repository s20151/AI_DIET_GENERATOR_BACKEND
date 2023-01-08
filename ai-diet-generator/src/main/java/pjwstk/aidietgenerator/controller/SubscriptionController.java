package pjwstk.aidietgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/subscription")
public class SubscriptionController {

    @GetMapping
    public String test(){
        return "test ok";
    }

}
