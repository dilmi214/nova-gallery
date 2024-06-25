package io.github.dilmi214.artgallery.nova_gallery.artist;

import io.github.dilmi214.artgallery.nova_gallery.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
