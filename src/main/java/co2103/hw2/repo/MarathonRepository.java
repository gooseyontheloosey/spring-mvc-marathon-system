package co2103.hw2.repo;

import co2103.hw2.model.Marathon;
import org.springframework.data.repository.CrudRepository;

public interface MarathonRepository extends CrudRepository<Marathon, Integer> {
    public Marathon findByName(String name);
    public Marathon findByRecordHolder_FirstName(String name);
}
