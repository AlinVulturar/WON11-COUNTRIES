import jakarta.persistence.*;

@Entity
public class Review {
    private String name;
    private int year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;
    private String reviewer;

    @ManyToOne
    private Movie movie;




    public Review(String name) {
        // Constructor gol necesar pentru JPA
        this.name = name;
        year = 0;
    }

    public Review(String name, int year) {
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
 55 changes: 55 additions & 0 deletions55
