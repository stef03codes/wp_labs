package mk.ukim.finki.wp.lab.repository;

import java.util.*;
import java.util.stream.Collectors;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
    private final List<Song> songs;

    public SongRepository() {
        songs = new ArrayList<>();
        songs.add(new Song("songId1", "newSongTitle1", "songGenre1", 2022,
                new Album(2L, "Album2", "genre2", "2022")));
        songs.add(new Song("songId2", "songTitle2", "songGenre2", 2023,
                new Album(5L, "Album5", "genre5", "2023")));
        songs.add(new Song("songId3", "songTitle3", "songGenre3", 2024,
                new Album(1L, "Album1", "genre1", "2024")));
        songs.add(new Song("songId4", "newSongTitle4", "songGenre4", 2021,
                new Album(3L, "Album3", "genre3", "2021")));
        songs.add(new Song("songId5", "songTitle5", "songGenre5", 2020,
                new Album(4L, "Album4", "genre4", "2020")));
    }

    public List<Song> findAll() {
        return songs;
    }

    public Song findByTrackId(String trackId) {
        return songs.stream()
                .filter(song -> song.getTrackId().equals(trackId))
                .findFirst()
                .orElse(null);
    }

    public List<Song> findByText(String text) {
        return songs
                .stream()
                .filter(song -> song.getTitle().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        Song s = findByTrackId(song.getTrackId());
        s.addArtist(artist);
        return artist;
    }

    // CRUD
    public void save(Song song) {
        if(songs.stream().anyMatch(s -> Objects.equals(s.getTitle(), song.getTitle()))) {
            Song delete = songs.stream().filter(s -> Objects.equals(s.getTitle(), song.getTitle())).findFirst().orElse(null);
            songs.remove(delete);
        }
        songs.add(song);
    }

    public Song findById(Long id) {
        return songs
                .stream()
                .filter(song -> Objects.equals(song.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public void delete(Song song) {
        songs.remove(song);
    }
}