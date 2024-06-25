package io.github.dilmi214.artgallery.nova_gallery.sale;

import io.github.dilmi214.artgallery.nova_gallery.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
