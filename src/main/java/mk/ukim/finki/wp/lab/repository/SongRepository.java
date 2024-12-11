package mk.ukim.finki.wp.lab.repository;

import java.util.*;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByTitle(String title);
    Song findByTrackId(String trackId);
//    Artist addArtistToSong(Artist artist, Song song);
}