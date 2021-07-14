package pl.piotrnarecki.coronavirustracker.models.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.piotrnarecki.coronavirustracker.services.CoronaVirusDataService;

// odpowiada za UI

@Controller
public class HomeController {

@Autowired
CoronaVirusDataService coronaVirusDataService;


    @GetMapping("/")
    public String home(Model model){


        model.addAttribute("locationStats",coronaVirusDataService.getAllStats());
        return "home";
    }


}
