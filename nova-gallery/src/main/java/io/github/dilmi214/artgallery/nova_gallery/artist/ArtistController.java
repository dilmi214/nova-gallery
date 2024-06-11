package io.github.dilmi214.artgallery.nova_gallery.artist;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPiece;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("")
    List<Artist> getAll(){
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    Optional<Artist> getById(@PathVariable Integer id){
        return artistService.getArtistById(id);
    }

    //creates artist without art pieces
    @PostMapping("/artist/save")
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }


    @PostMapping("/artist/{artistId}/artpiece/save")
    public ArtPiece addArtPieceToArtist(@PathVariable Integer artistId, @RequestBody ArtPiece artPiece) {
        return artistService.addArtPieceToArtist(artistId, artPiece);
    }
}
