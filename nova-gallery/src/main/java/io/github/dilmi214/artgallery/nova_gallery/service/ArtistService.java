package io.github.dilmi214.artgallery.nova_gallery.service;

import io.github.dilmi214.artgallery.nova_gallery.model.ArtPiece;
import io.github.dilmi214.artgallery.nova_gallery.repository.ArtPieceRepository;
import io.github.dilmi214.artgallery.nova_gallery.model.Artist;
import io.github.dilmi214.artgallery.nova_gallery.repository.ArtistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtPieceRepository artPieceRepository;

    public ArtistService(ArtistRepository artistRepository, ArtPieceRepository artPieceRepository) {
        this.artistRepository = artistRepository;
        this.artPieceRepository = artPieceRepository;
    }

    //GET - get all artists
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(Integer id) {
        return artistRepository.findById(id);
    }

    //POST - create artist without art pieces
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }


    private void validateArtist(Artist artist) {
        if (artist.getName() == null || artist.getName().isBlank()) {
            throw new IllegalArgumentException("Artist name cannot be null or blank.");
        }
        if (artist.getBio() == null || artist.getBio().isBlank()) {
            throw new IllegalArgumentException("Artist bio cannot be null or blank.");
        }
    }



    @Transactional
    public ArtPiece addArtPieceToArtist(Integer artistId, ArtPiece artPiece) {
        Optional<Artist> optionalArtist = artistRepository.findById(artistId);

        if (optionalArtist.isEmpty()) {
            throw new IllegalArgumentException("Artist with ID " + artistId + " not found.");
        }

        Artist artist = optionalArtist.get();
        artPiece.assignArtist(artist);

        // Save the ArtPiece entity
        return artPieceRepository.save(artPiece);
    }



    public void deleteArtistById(Integer id) {
        artistRepository.deleteById(id);
    }

    public void updateArtist(Artist artist, Integer id) {
        artistRepository.save(artist);
    }
}
