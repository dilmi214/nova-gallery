package io.github.dilmi214.artgallery.nova_gallery.repository;

import io.github.dilmi214.artgallery.nova_gallery.model.ArtPiece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtPieceRepository extends JpaRepository<ArtPiece, Integer> {
    // Method to find ArtPieces by artist id
    List<ArtPiece> findByArtistId(Integer artistId);
}
