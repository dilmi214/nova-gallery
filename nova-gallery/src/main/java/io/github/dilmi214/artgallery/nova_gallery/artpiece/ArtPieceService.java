package io.github.dilmi214.artgallery.nova_gallery.artpiece;

import io.github.dilmi214.artgallery.nova_gallery.model.ArtPiece;
import io.github.dilmi214.artgallery.nova_gallery.model.Artist;
import io.github.dilmi214.artgallery.nova_gallery.artist.ArtistRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtPieceService {

    private final ArtPieceRepository artPieceRepository;
    private final ArtistRepository artistRepository;

    public ArtPieceService(ArtPieceRepository artPieceRepository, ArtistRepository artistRepository) {
        this.artPieceRepository = artPieceRepository;
        this.artistRepository = artistRepository;
    }

    public List<ArtPiece> getAll(){
        return artPieceRepository.findAll();
    }

    public Optional<ArtPiece> getById(Integer id){
        return artPieceRepository.findById(id);
    }

    //create art piece
    public ArtPiece saveArtPiece(ArtPiece artPiece) {
        return artPieceRepository.save(artPiece);
    }

    //PUT - assign artist to art piece after both have been created separately
    ArtPiece assignArtistToArtPiece(Integer artPieceId, Integer artistId) {
        ArtPiece artPiece = artPieceRepository.findById(artPieceId).orElseThrow();
        Artist artist = artistRepository.findById(artistId).orElseThrow();
        artPiece.assignArtist(artist);
        return artPieceRepository.save(artPiece);
    }

//    @Transactional
//    public ArtPiece createAndAssignArtPiece(ArtPiece artPiece, Integer artistId) {
//        Artist artist = artistRepository.findById(artistId).orElseThrow();
//        artPiece.assignArtist(artist);
//        return artPieceRepository.save(artPiece);
//    }

    @Transactional
    public ArtPiece createAndAssignArtPiece(ArtPiece artPiece, Integer artistId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow();
        artPiece.assignArtist(artist);
        return artPieceRepository.save(artPiece);
    }

    public List<ArtPiece> findByArtistId(Integer artistId){
        return artPieceRepository.findByArtistId(artistId);
    }



}
