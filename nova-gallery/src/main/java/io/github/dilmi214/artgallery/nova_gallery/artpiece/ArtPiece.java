package io.github.dilmi214.artgallery.nova_gallery.artpiece;

import io.github.dilmi214.artgallery.nova_gallery.artist.Artist;
import io.github.dilmi214.artgallery.nova_gallery.exhibition.Exhibition;
import io.github.dilmi214.artgallery.nova_gallery.sale.Sale;

import java.util.List;

public class ArtPiece {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Artist artist;
    private List<Exhibition> exhibitions;
    private Sale sale;


    public ArtPiece() {
    }

    public ArtPiece(int id, String title, String description, Double price, Artist artist, List<Exhibition> exhibitions, Sale sale) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.artist = artist;
        this.exhibitions = exhibitions;
        this.sale = sale;
    }

    public ArtPiece(String title, String description, Double price, Artist artist, List<Exhibition> exhibitions, Sale sale) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.artist = artist;
        this.exhibitions = exhibitions;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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

    @Override
    public String toString() {
        return "ArtPiece{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", artist=" + artist +
                ", exhibitions=" + exhibitions +
                ", sale=" + sale +
                '}';
    }
}
