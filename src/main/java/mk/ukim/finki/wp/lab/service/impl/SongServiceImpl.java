package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    public final SongRepository songRepository;
    public final AlbumRepository albumRepository;
    public final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Song::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public List<Song> search(String text) {
        return songRepository
                .findAll()
                .stream()
                .filter(song -> song.getTitle().toLowerCase().contains(text))
                .collect(Collectors.toList());
    }

    @Override
    public void addSong(String title, String trackId, String genre, Integer releaseYear, Long albumId) {
        albumRepository.findById(albumId).ifPresent(album ->
                songRepository.save(new Song(trackId, title, genre, releaseYear, album))
        );
    }

    @Override
    public void editSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findSongById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteSong(Long songId) {
        findSongById(songId).ifPresent(songRepository::delete);
    }

    @Override
    public void rateSong(Long songId, float rating) {
        songRepository.findById(songId).ifPresent(song -> {
            song.setRating(rating);
            songRepository.save(song);
        });
    }

}
