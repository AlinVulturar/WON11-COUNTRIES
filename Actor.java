import jakarta.persistence.*;

import java.util.List;

@Entity
public class Actor {
    private int year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int birthYear;

    @ManyToMany(mappedBy = "cast")
    private List<Movie> movies;


    public Actor(int year) {
        // Constructor gol necesar pentru JPA
        this.year = year;
    }

    public Actor(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
