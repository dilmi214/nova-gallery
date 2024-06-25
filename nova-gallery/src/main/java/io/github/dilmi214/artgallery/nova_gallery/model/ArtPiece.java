package io.github.dilmi214.artgallery.nova_gallery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(nullable = true)
    private String imageUrl;

//    @Lob
//    @Column(name = "image", columnDefinition="BLOB")
//    private byte[] image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;


    @ManyToMany(mappedBy = "artPieces")
    @JsonIgnore
    private List<Exhibition> exhibitions;

    @OneToOne(mappedBy = "artPiece", cascade = CascadeType.ALL, orphanRemoval = true)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curator_id")
    private Curator curator;


    public ArtPiece() {
    }

    public ArtPiece(Integer id, String title, String description, Double price, String imageUrl, List<Exhibition> exhibitions, Sale sale, Curator curator) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.exhibitions = exhibitions;
        this.sale = sale;
        this.curator = curator;
    }

    public ArtPiece(String title, String description, Double price, String imageUrl, List<Exhibition> exhibitions, Sale sale, Curator curator) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
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

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
