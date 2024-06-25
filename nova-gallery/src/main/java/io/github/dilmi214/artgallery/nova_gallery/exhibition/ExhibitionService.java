package io.github.dilmi214.artgallery.nova_gallery.exhibition;

import io.github.dilmi214.artgallery.nova_gallery.model.ArtPiece;
import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPieceRepository;
import io.github.dilmi214.artgallery.nova_gallery.model.Exhibition;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;
    private final ArtPieceRepository artPieceRepository;

    public ExhibitionService(ExhibitionRepository exhibitionRepository, ArtPieceRepository artPieceRepository) {
        this.exhibitionRepository = exhibitionRepository;
        this.artPieceRepository = artPieceRepository;
    }

    public Exhibition createExhibition1(Exhibition exhibition) {
        List<ArtPiece> artPieces = new ArrayList<>();
        for (ArtPiece artPiece : exhibition.getArtPieces()) {
            Integer id = artPiece.getId();
            artPieceRepository.findById(id).ifPresent(artPieces::add);
        }
        exhibition.setArtPieces(artPieces);
        return exhibitionRepository.save(exhibition);
    }

    public Exhibition createExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    public Exhibition getExhibition(Integer id) {
        return exhibitionRepository.findById(id).orElse(null);
    }

    public List<Exhibition> getAllExhibitions() {
        return exhibitionRepository.findAll();
    }

    public void deleteExhibition(Integer id) {
        exhibitionRepository.deleteById(id);
    }

    public Exhibition updateExhibition(Integer id, Exhibition exhibition) {
        Exhibition existingExhibition = exhibitionRepository.findById(id).orElse(null);
        if (existingExhibition == null) {
            return null;
        }
        existingExhibition.setName(exhibition.getName());
        existingExhibition.setStartDate(exhibition.getStartDate());
        existingExhibition.setEndDate(exhibition.getEndDate());
        existingExhibition.setLocation(exhibition.getLocation());
        existingExhibition.setArtPieces(exhibition.getArtPieces());
        return exhibitionRepository.save(existingExhibition);
    }

    public List<Exhibition> getExhibitionsByLocation(Location location) {
        return exhibitionRepository.findByLocation(location);
    }

    public List<Exhibition> getExhibitionsByArtPiece(Integer artPieceId) {
        return exhibitionRepository.findByArtPiecesId(artPieceId);
    }


}
