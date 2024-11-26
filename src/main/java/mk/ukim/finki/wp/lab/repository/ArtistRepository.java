package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.*;
import mk.ukim.finki.wp.lab.model.Artist;

@Repository
public class ArtistRepository {
    private final List<Artist> artists;

    public ArtistRepository() {
        artists = new ArrayList<>();
        artists.add(new Artist(1L, "a", "ab", "aa"));
        artists.add(new Artist(2L, "b", "ba", "bb"));
        artists.add(new Artist(3L, "c", "ac", "cc"));
        artists.add(new Artist(4L, "d", "ad", "dd"));
        artists.add(new Artist(5L, "e", "ea", "ee"));
    }

    public List<Artist> findAll() {
        return artists;
    }

    public Optional<Artist> findById(Long id) {
        return artists
                .stream()
                .filter(artist -> Objects.equals(artist.getId(), id))
                .findFirst();
    }
}
