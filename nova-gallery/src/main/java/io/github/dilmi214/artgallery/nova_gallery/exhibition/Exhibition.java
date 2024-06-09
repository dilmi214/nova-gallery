package io.github.dilmi214.artgallery.nova_gallery.exhibition;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPiece;

import java.time.LocalDate;
import java.util.List;

public class Exhibition {
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Location location;
    private List<ArtPiece> artPieces;

    public Exhibition() {
    }

    public Exhibition(Integer id, String name, LocalDate startDate, LocalDate endDate, Location location, List<ArtPiece> artPieces) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.artPieces = artPieces;
    }

    public Exhibition(String name, LocalDate startDate, LocalDate endDate, Location location, List<ArtPiece> artPieces) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.artPieces = artPieces;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ArtPiece> getArtPieces() {
        return artPieces;
    }

    public void setArtPieces(List<ArtPiece> artPieces) {
        this.artPieces = artPieces;
    }
}
