package co2103.hw2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


// child to Runner
@Entity
public class Ranks {
    @GeneratedValue
    @Id
    private int id;
    private int time;

    @Override
    public String toString() {
        return "Ranks{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
