package mk.ukim.finki.wp.lab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Song {
    private Long id;
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List <Artist> performers;
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.id = new Random().nextLong();
        this.album = album;
    }

    public void addArtist(Artist artist) {
        performers.add(artist);
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Genre: %s, Release Year: %d, Album: %s",
                title, genre, releaseYear, album.getName());
    }
}
