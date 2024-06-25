package io.github.dilmi214.artgallery.nova_gallery.artist;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPieceService;
import io.github.dilmi214.artgallery.nova_gallery.model.Artist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;
    private final ArtPieceService artPieceService;

    public ArtistController(ArtistService artistService, ArtPieceService artPieceService) {
        this.artistService = artistService;
        this.artPieceService = artPieceService;
    }

    @GetMapping("")
    public String getArtistTemplate() {
        return "Artist/artist";
    }

    @GetMapping("/allArtists")
    public String getArtists() {
        return "Artist/allArtists";
    }

    @GetMapping("/artistProfile/{id}")
    public String getArtistProfile(Model model){
        return "Artist/artistProfile";
    }

    @GetMapping("/all")
    @ResponseBody
    List<Artist> getAll(){
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Optional<Artist> getById(@PathVariable Integer id){
        return artistService.getArtistById(id);
    }

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
