package io.github.dilmi214.artgallery.nova_gallery.artpiece;

import io.github.dilmi214.artgallery.nova_gallery.artist.Artist;
import io.github.dilmi214.artgallery.nova_gallery.curator.Curator;
import io.github.dilmi214.artgallery.nova_gallery.exhibition.Exhibition;
import io.github.dilmi214.artgallery.nova_gallery.sale.Sale;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ArtPiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 250)
    private String title;
    @Column(nullable = false, length = 250)
    private String description;
    @Column(nullable = false)
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @ManyToMany(mappedBy = "artPieces")
    private List<Exhibition> exhibitions;

    @OneToOne(mappedBy = "artPiece", cascade = CascadeType.ALL, orphanRemoval = true)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curator_id")
    private Curator curator;


    public ArtPiece() {
    }

    public ArtPiece(Integer id, String title, String description, Double price, List<Exhibition> exhibitions, Sale sale) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.exhibitions = exhibitions;
        this.sale = sale;
    }

    public ArtPiece(String title, String description, Double price, List<Exhibition> exhibitions, Sale sale) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.exhibitions = exhibitions;
        this.sale = sale;
        this.curator = curator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Exhibition> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<Exhibition> exhibitions) {
        this.exhibitions = exhibitions;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    public Artist getArtist() {
        return artist;
    }

    public void assignArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "ArtPiece{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", exhibitions=" + exhibitions +
                ", sale=" + sale +
                ", curator=" + curator +
                '}';
    }
}
