package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import java.util.*;

public interface ArtistService {
    List<Artist> listArtists();
    Artist ArtistfindById(Long id);
}
