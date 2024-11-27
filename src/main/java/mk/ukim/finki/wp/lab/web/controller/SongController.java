package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("songs", songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/add")
    public String persistSongPage(Model model) {
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
        songService.addSong(title, trackId, genre, releaseYear, albumId);
        return "redirect:/listSongs";
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Song song = songService.findSongById(songId);

        model.addAttribute("songToEdit", song);
        model.addAttribute("currentSongAlbum", song.getAlbum());

        return "add-song";
    }

    @DeleteMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return "redirect:/listSongs";
    }
}
