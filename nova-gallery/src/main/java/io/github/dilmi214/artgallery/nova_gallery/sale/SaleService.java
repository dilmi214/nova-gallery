package io.github.dilmi214.artgallery.nova_gallery.sale;

import io.github.dilmi214.artgallery.nova_gallery.model.ArtPiece;
import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPieceService;
import io.github.dilmi214.artgallery.nova_gallery.model.Sale;
import io.github.dilmi214.artgallery.nova_gallery.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private SaleRepository saleRepository;
    private ArtPieceService artPieceService;

    public SaleService(SaleRepository saleRepository, ArtPieceService artPieceService) {
        this.saleRepository = saleRepository;
        this.artPieceService = artPieceService;
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale createSaleAndAssignArtPiece(Sale sale, Integer artPieceId) {
        Optional<ArtPiece> artPiece = artPieceService.getById(artPieceId);
        sale.setArtPiece(artPiece.orElseThrow());
        return saleRepository.save(sale);
    }
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    public Sale getSale(Integer id) {
        return saleRepository.findById(id).orElse(null);
    }

    public void deleteSale(Integer id) {
        saleRepository.deleteById(id);
    }

    public Sale updateSale(Sale sale) {
        return saleRepository.save(sale);
    }

}
