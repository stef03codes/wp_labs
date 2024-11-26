package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Album {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
}
