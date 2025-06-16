package co2103.hw2.repo;

import co2103.hw2.model.Runner;
import org.springframework.data.repository.CrudRepository;

public interface RunnerRepository extends CrudRepository<Runner, String> {
    public Runner findByFirstName(String name);
}
