import jakarta.persistence.*;

@Entity
public class MovieRating {
    private String name;
    private int year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int rating;
    private String agency;

    @OneToOne
    private Movie movie;



    public MovieRating(int year) {
        // Constructor gol necesar pentru JPA
        this.year = year;
    }

    public MovieRating(String name, int year) {
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
