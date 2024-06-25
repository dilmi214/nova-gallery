package io.github.dilmi214.artgallery.nova_gallery.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "artpiece_id")
    private ArtPiece artPiece;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private LocalDate saleDate;
    private Double price;

    public Sale() {
    }

    public Sale(Integer id, ArtPiece artPiece, Customer customer, LocalDate saleDate, Double price) {
        this.id = id;
        this.artPiece = artPiece;
        this.customer = customer;
        this.saleDate = saleDate;
        this.price = price;
    }

    public Sale(ArtPiece artPiece, Customer customer, LocalDate saleDate, Double price) {
        this.artPiece = artPiece;
        this.customer = customer;
        this.saleDate = saleDate;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArtPiece getArtPiece() {
        return artPiece;
    }

    public void setArtPiece(ArtPiece artPiece) {
        this.artPiece = artPiece;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", artPiece=" + artPiece +
                ", customer=" + customer +
                ", saleDate=" + saleDate +
                ", price=" + price +
                '}';
    }
}
