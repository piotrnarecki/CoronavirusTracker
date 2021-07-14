package pl.piotrnarecki.coronavirustracker.models.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// odpowiada za UI

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }


}
