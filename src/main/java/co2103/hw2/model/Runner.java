package co2103.hw2.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

// child to Marathon, parent to Ranks
@Entity
public class Runner {
    @Id
    private String firstName;
    @ManyToMany(mappedBy = "runners") // references list in parent class (Marathon)
    private List<Marathon> marathons;
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER) // orphan removal on parent side (Ranks is child)
    @JoinColumn // Runner class is parent (@JC)
    private List<Ranks> ranks;
    @OneToOne
    private Ranks mostRecent;

    @Override
    public String toString() {
        return "Runner{" +
                "firstName='" + firstName + '\'' +
                ", ranks=" + ranks +
                ", mostRecent=" + mostRecent +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Marathon> getMarathons() {
        return marathons;
    }

    public void setMarathons(List<Marathon> marathons) {
        this.marathons = marathons;
    }

    public List<Ranks> getRanks() {
        return ranks;
    }

    public void setRanks(List<Ranks> ranks) {
        this.ranks = ranks;
    }

    public Ranks getMostRecent() {
        return mostRecent;
    }

    public void setMostRecent(Ranks mostRecent) {
        this.mostRecent = mostRecent;
    }
}
