package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import java.util.*;


public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    List<Song> search(String text);
    void addSong(String title, String trackId, String genre, Integer releaseYear, Long albumId);
    Song findSongById(Long id);
}
