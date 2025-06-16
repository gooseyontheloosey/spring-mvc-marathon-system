package co2103.hw2.controller;

import co2103.hw2.Hw2Application;
import co2103.hw2.repo.MarathonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @Autowired
    private MarathonRepository marathonRepository;

    @GetMapping("/list")
    public String task5pt2(Model model) {
        model.addAttribute("marathons", marathonRepository.findAll());
        return "list";
    }
}
