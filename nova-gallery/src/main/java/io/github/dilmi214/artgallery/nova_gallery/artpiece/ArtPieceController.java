package io.github.dilmi214.artgallery.nova_gallery.artpiece;

import io.github.dilmi214.artgallery.nova_gallery.artist.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artPieces")
public class ArtPieceController {

    private final ArtPieceService artPieceService;
    private final ArtistService artistService;

    public ArtPieceController(ArtPieceService artPieceService, ArtistService artistService) {
        this.artPieceService = artPieceService;
        this.artistService = artistService;
    }

    @GetMapping("")
    List<ArtPiece> getAll(){
        return artPieceService.getAll();
    }


    @PostMapping("/artPiece/save")
    public ArtPiece createArtPiece(@RequestBody ArtPiece artPiece) {
        return artPieceService.saveArtPiece(artPiece);
    }


    @PutMapping("/{artPieceId}/artist/{artistId}")
    public ArtPiece assignArtistToArtPiece(@PathVariable Integer artPieceId, @PathVariable Integer artistId) {
        return artPieceService.assignArtistToArtPiece(artPieceId, artistId);
    }

//    @PostMapping("/artPiece")
//    public ResponseEntity<ArtPiece> createArtPiece(@RequestBody ArtPiece artPiece, @RequestParam Integer artistId) {
//        ArtPiece savedArtPiece = artPieceService.createAndAssignArtPiece(artPiece, artistId);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedArtPiece);
//    }

    @PostMapping("/artPiece")
    public void createArtPieceAndAssign(@RequestBody ArtPiece artPiece) {
        Integer artistId = artPiece.getArtist().getId();
        ArtPiece savedArtPiece = artPieceService.createAndAssignArtPiece(artPiece, artistId);

    }

}
