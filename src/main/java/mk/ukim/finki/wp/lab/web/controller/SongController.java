package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/songs")
public class SongController {
    public final SongService songService;
    public final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(name = "search", required = false) String search, Model model) {
        if(search == null) {
            model.addAttribute("songs", songService.listSongs());
        } else {
            model.addAttribute("songs", songService.search(search));
        }
        return "listSongs";
    }

    @GetMapping("/add")
    public String addSongPage(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @PostMapping("/add")
    public String saveSong
            (@RequestParam(name = "title") String title,
             @RequestParam(name = "trackId") String trackId,
             @RequestParam(name = "genre") String genre,
             @RequestParam(name = "releaseYear") Integer releaseYear,
             @RequestParam(name = "albumId") Long albumId)
    {
        Song song = songService.findByTrackId(trackId);
        if(song != null) {
            song.setTrackId(trackId);
            song.setTitle(title);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            song.setAlbum(albumService.findById(albumId));
            songService.editSong(song);
        } else {
            songService.addSong(title, trackId, genre, releaseYear, albumId);
        }
        return "redirect:/songs";
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Song song = songService.findSongById(songId).orElse(null);

        if(song != null) {
            Album album = song.getAlbum();

            model.addAttribute("songToEdit", song);
            model.addAttribute("currentSongAlbum", song.getAlbum());
            model.addAttribute("albums",
                    albumService.findAll().stream().filter(a -> !a.equals(album)).collect(Collectors.toList()));
        }

        return "add-song";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}
