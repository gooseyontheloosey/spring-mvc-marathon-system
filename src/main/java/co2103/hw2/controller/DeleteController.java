package co2103.hw2.controller;

import co2103.hw2.Hw2Application;
import co2103.hw2.model.Marathon;
import co2103.hw2.model.Runner;
import co2103.hw2.repo.MarathonRepository;
import co2103.hw2.repo.RanksRepository;
import co2103.hw2.repo.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    private MarathonRepository marathonRepository;

    @Autowired
    private RunnerRepository runnerRepository;

    @Autowired
    private RanksRepository ranksRepository;

    @GetMapping("/deleteMarathon")
    public String deleteMarathon(@RequestParam int id) {
        if (marathonRepository.existsById(id)) {
            marathonRepository.deleteById(id);
        }
        return "redirect:/list";
    }

    @GetMapping("/deleteRunner")
    public String deleteRunner(@RequestParam String firstName) {
        for (Runner r : runnerRepository.findAll()) {
            if (r == runnerRepository.findByFirstName(firstName)) {
                runnerRepository.delete(r);
            }
        }
        // marathonRepository.delete(marathonRepository.findByRecordHolder_FirstName(firstName));

        return "redirect:/list";
    }

    @GetMapping("/deleteRanks")
    public String deleteRank(@RequestParam int id) {
        if (ranksRepository.existsById(id)) {
            ranksRepository.deleteById(id);
        }
        return "redirect:/list";
    }
}
