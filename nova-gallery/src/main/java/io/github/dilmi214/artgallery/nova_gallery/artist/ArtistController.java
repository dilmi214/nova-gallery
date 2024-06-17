package io.github.dilmi214.artgallery.nova_gallery.artist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("")
    public String getArtistTemplate(Model model) {
        // Add data to the model for dynamic content in the template
        //model.addAttribute("message", "Welcome to the Artist page");
        return "Artist/artist"; // Name of the Thymeleaf template
    }

    @GetMapping("/allArtists")
    public String getArtists(Model model) {
        // Add data to the model for dynamic content in the template
        //model.addAttribute("message", "Welcome to the Artist page");
        return "Artist/allArtists"; // Name of the Thymeleaf template
    }

    @GetMapping("/all")
    @ResponseBody
    List<Artist> getAll(){
        return artistService.getAll();
    }
//
//    @GetMapping("/{id}")
//    Optional<Artist> getById(@PathVariable Integer id){
//        return artistService.getArtistById(id);
//    }
//
    //creates artist without art pieces
    @PostMapping("/artist/save")
    @ResponseBody
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

//
//    @PostMapping("/artist/{artistId}/artpiece/save")
//    public ArtPiece addArtPieceToArtist(@PathVariable Integer artistId, @RequestBody ArtPiece artPiece) {
//        return artistService.addArtPieceToArtist(artistId, artPiece);
//    }
}
