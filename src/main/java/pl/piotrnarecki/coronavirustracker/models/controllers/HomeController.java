package pl.piotrnarecki.coronavirustracker.models.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.piotrnarecki.coronavirustracker.models.LocationStats;
import pl.piotrnarecki.coronavirustracker.services.CoronaVirusDataService;

import java.util.List;

// odpowiada za UI

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;


    @GetMapping("/")
    public String home(Model model) {

        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum(); // laczna ilosc zakazen
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum(); // laczna ilosc zakazen


        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);


        return "home";
    }


}
