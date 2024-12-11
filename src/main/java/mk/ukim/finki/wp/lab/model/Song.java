package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String trackId;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;
    @Column(name = "rating", columnDefinition = "FLOAT DEFAULT 0.0")
    private float rating;

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.album = album;
    }

    public Artist addArtist(Artist artist) {
        performers.add(artist);
        return artist;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Genre: %s, Release Year: %d, Album: %s",
                title, genre, releaseYear, album.getName());
    }

    public void setRating(float rating) {
        if(this.rating == 0.0)
            this.rating = rating;
        else
            this.rating = (this.rating + rating) / 2;
    }
}
