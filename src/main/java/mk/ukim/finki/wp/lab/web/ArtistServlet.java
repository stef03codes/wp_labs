//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "ArtistServlet", urlPatterns = "/artist")
//public class ArtistServlet extends HttpServlet {
//    public final SongService songService;
//    public final ArtistService artistService;
//    public final SpringTemplateEngine springTemplateEngine;
//
//    public ArtistServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.artistService = artistService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        String songId = req.getParameter("trackId");
//
//        context.setVariable("song", songService.findByTrackId(songId));
//        context.setVariable("artists", artistService.listArtists());
//
//        springTemplateEngine.process("artistsList.html", context, resp.getWriter());
//    }
//}
