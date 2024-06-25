package io.github.dilmi214.artgallery.nova_gallery.repository;

import io.github.dilmi214.artgallery.nova_gallery.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

//        @Query("SELECT a.artPieces FROM Artist a WHERE a.id = :artistId")
//        List<ArtPiece> findArtPiecesByArtistId(@Param("artistId") Integer artistId);


}
