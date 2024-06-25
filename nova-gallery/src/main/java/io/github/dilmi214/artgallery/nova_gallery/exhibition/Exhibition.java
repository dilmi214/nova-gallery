package io.github.dilmi214.artgallery.nova_gallery.exhibition;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPiece;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 250)
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Location location;
    @ManyToMany
    @JoinTable(
            name = "exhibition_artPiece",
            joinColumns = @JoinColumn(name = "exhibition_id"),
            inverseJoinColumns = @JoinColumn(name = "artPiece_id")
    )
    private List<ArtPiece> artPieces;

    public Exhibition() {
    }

    public Exhibition(Integer id, String name, String description, LocalDate startDate, LocalDate endDate, Location location, List<ArtPiece> artPieces) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.artPieces = artPieces;
    }

    public Exhibition(String name, String description, LocalDate startDate, LocalDate endDate, Location location, List<ArtPiece> artPieces) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
