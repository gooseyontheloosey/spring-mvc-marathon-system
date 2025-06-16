package co2103.hw2.repo;

import co2103.hw2.model.Ranks;
import org.springframework.data.repository.CrudRepository;

public interface RanksRepository extends CrudRepository<Ranks, Integer> {
    public Ranks findByTime(int time);
}
