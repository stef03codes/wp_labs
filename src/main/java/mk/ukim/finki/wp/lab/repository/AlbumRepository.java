package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AlbumRepository {
    public List<Album> albums;

    public AlbumRepository() {
        albums = new ArrayList<>();
        albums.add(new Album(1L, "Album1", "genre1", "2024"));
        albums.add(new Album(2L, "Album2", "genre2", "2022"));
        albums.add(new Album(3L, "Album3", "genre3", "2021"));
        albums.add(new Album(4L, "Album4", "genre4", "2020"));
        albums.add(new Album(5L, "Album5", "genre5", "2023"));
    }

    public List<Album> findAll() {
        return albums;
    }
    public Album findById(Long id) {
        return albums
                .stream()
                .filter(album -> Objects.equals(album.getId(), id))
                .findFirst().orElse(null);
    }
}
