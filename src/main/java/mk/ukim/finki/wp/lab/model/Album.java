package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String genre;
    @Column
    private String releaseYear;

    public Album(String name, String genre, String releaseYear) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", name, genre, releaseYear);
    }
}
