import jakarta.persistence.*;

import java.util.List;

@Entity
public class Studio {
    private int year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "studio")
    private List<Movie> movies;

    public Studio(int year) {
        // Constructor gol necesar pentru JPA
        this.year = year;
    }

    public Studio(String name, int year) {
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

