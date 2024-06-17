package io.github.dilmi214.artgallery.nova_gallery;

import io.github.dilmi214.artgallery.nova_gallery.artist.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lol")
public class AllController {

    @GetMapping("")
    public String artist(){
        return "Artist/artist";
    }

    @GetMapping("/saveArtpiece")
    public String artPiece(){
        return "ArtPiece/artpiece";
    }
}
