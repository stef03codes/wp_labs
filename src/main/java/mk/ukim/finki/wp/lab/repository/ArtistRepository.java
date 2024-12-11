package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import mk.ukim.finki.wp.lab.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
