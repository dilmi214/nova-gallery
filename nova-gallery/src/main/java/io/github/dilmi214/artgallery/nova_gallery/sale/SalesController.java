package io.github.dilmi214.artgallery.nova_gallery.sale;

import io.github.dilmi214.artgallery.nova_gallery.model.Sale;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SaleService saleService;

    public SalesController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/sale/save")
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    //fix this
    @PostMapping("/sale/")
    public Sale createSaleAndAssignArtPiece(Sale sale, Integer artPieceId) {
        return saleService.createSaleAndAssignArtPiece(sale, artPieceId);
    }

    @GetMapping("")
    public List<Sale> getSales() {
        return saleService.getSales();
    }

    @GetMapping("/{id}")
    public Sale getSale(Integer id) {
        return saleService.getSale(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(Integer id) {
        saleService.deleteSale(id);
    }

    @PutMapping("/sale/update")
    public Sale updateSale(Sale sale) {
        return saleService.updateSale(sale);
    }

}
