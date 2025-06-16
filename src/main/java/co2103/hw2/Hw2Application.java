package co2103.hw2;

import co2103.hw2.model.Marathon;
import co2103.hw2.model.Ranks;
import co2103.hw2.model.Runner;
import co2103.hw2.repo.MarathonRepository;
import co2103.hw2.repo.RanksRepository;
import co2103.hw2.repo.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw2Application implements CommandLineRunner {
    @Autowired
    private MarathonRepository marathonRepository;

    @Autowired
    private RunnerRepository runnerRepository;

    @Autowired
    private RanksRepository ranksRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Marathon marathon1 = new Marathon();
        marathon1.setName("The Big Marathon - Egg & Spoon Race");
        Marathon marathon2 = new Marathon();
        marathon2.setName("The Big Marathon - Three-Legged Race");

        marathon1 = marathonRepository.save(marathon1);
        marathon2 = marathonRepository.save(marathon2);

        List<Marathon> marathonsList = new ArrayList<>();
        marathonsList.add(marathon1); // modifying marathonsList (reused)

        Ranks rank1 = new Ranks();
        rank1.setTime(25);
        Ranks rank2 = new Ranks();
        rank2.setTime(9);
        Ranks rank3 = new Ranks();
        rank3.setTime(14);
        Ranks rank4 = new Ranks();
        rank4.setTime(21);
        Ranks rank5 = new Ranks();
        rank5.setTime(20);

        rank1 = ranksRepository.save(rank1);
        rank2 = ranksRepository.save(rank2);
        rank3 = ranksRepository.save(rank3);
        rank4 = ranksRepository.save(rank4);
        rank5 = ranksRepository.save(rank5);

        List<Ranks> ranksList = new ArrayList<>();
        ranksList.add(rank5); // modifying ranksList (reused)

        Runner runner1 = new Runner();
        runner1.setFirstName("Hafsah"); // in marathon 1
        runner1.setMarathons(marathonsList);
        runner1.setRanks(ranksList);
        runner1.setMostRecent(rank5);
        runner1 = runnerRepository.save(runner1);

        ranksList.remove(rank5); // modifying ranksList
        ranksList.add(rank1);
        ranksList.add(rank4);
        marathonsList.add(marathon2); // modifying marathonsList

        Runner runner2 = new Runner(); // in marathon 1 & 2
        runner2.setFirstName("Gracie");
        runner2.setMarathons(marathonsList);
        runner2.setRanks(ranksList);
        runner2.setMostRecent(rank1);
        runner2 = runnerRepository.save(runner2);

        ranksList.remove(rank4); // modifying ranksList
        ranksList.remove(rank1);
        ranksList.add(rank2);
        ranksList.add(rank3);

        Runner runner3 = new Runner();
        runner3.setFirstName("Cassy"); // in marathon 1 & 2
        runner3.setMarathons(marathonsList);
        runner3.setRanks(ranksList);
        runner3.setMostRecent(rank3);
        runner3 = runnerRepository.save(runner3);

        List<Runner> runnersList = new ArrayList<>();
        runnersList.add(runner1); // modifying runnersList (reused)
        runnersList.add(runner2);
        runnersList.add(runner3);

        marathon1.setRunners(runnersList);
        marathon1.setRecordHolder(runner3);
        marathon1 = marathonRepository.save(marathon1);

        runnersList.remove(runner1); // modifying runnersList

        marathon2.setRunners(runnersList);
        marathon2.setRecordHolder(runner3);
        marathon2 = marathonRepository.save(marathon2);
    }
}