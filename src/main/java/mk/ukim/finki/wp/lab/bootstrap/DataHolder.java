package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataHolder {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public DataHolder(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    public void init() {
        List<Song> songs = songRepository.findAll();
        List<Artist> artists = artistRepository.findAll();
        List<Album> albums = albumRepository.findAll();

        if(artists.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                artistRepository.save(new Artist("Firstname" + i,
                        "Lastname" + i, "Bio" + i));
            }
        }

        if(albums.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                int randomYear = 1999 + (int)(Math.random() * 2024 - 1999) + 1;
                albumRepository.save(new Album("Album" + i, "Genre" + i, Integer.toString(randomYear)));
            }
        }

        if(songs.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                int randomYear = 1999 + (int)(Math.random() * 2024 - 1999) + 1;
                long randomAlbumId = (int)(Math.random() * 5) + 1;
                songRepository.save(new Song("TrackId" + i, "SongTitle" + i,
                        "Genre" + i, randomYear, albumRepository.findById(randomAlbumId).orElse(null)));
            }
        }
    }
}
