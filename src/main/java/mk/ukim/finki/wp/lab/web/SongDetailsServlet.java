//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
//public class SongDetailsServlet extends HttpServlet {
//    public final SongService songService;
//    public final ArtistService artistService;
//    public final SpringTemplateEngine springTemplateEngine;
//
//    public SongDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.artistService = artistService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        Long artistId = Long.parseLong(req.getParameter("artistId"));
//        String trackId = req.getParameter("trackId");
//
//        Artist artist = artistService.ArtistfindById(artistId);
//        Song song = songService.findByTrackId(trackId);
//
//        context.setVariable("song", song);
//        songService.addArtistToSong(artist, song);
//        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
//    }
//}
