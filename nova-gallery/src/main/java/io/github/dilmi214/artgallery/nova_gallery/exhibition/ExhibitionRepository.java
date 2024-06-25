package io.github.dilmi214.artgallery.nova_gallery.exhibition;

import io.github.dilmi214.artgallery.nova_gallery.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ExhibitionRepository extends JpaRepository<Exhibition, Integer> {
    List<Exhibition> findByLocation(Location location);
    List<Exhibition> findByArtPiecesId(Integer artPieceId);
}
