package co2103.hw2.model;

import javax.persistence.*;
import java.util.List;

// parent to Runner
@Entity
public class Marathon {
    @GeneratedValue
    @Id
    private int id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // cascade goes on parent side
    private List<Runner> runners;
    @ManyToOne
    private Runner recordHolder;

    @Override
    public String toString() {
        return "Marathon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", runners=" + runners +
                ", recordHolder=" + recordHolder +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    public Runner getRecordHolder() {
        return recordHolder;
    }

    public void setRecordHolder(Runner recordHolder) {
        this.recordHolder = recordHolder;
    }
}
