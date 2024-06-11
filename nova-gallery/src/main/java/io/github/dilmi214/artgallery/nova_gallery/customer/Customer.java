package io.github.dilmi214.artgallery.nova_gallery.customer;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPiece;
import io.github.dilmi214.artgallery.nova_gallery.sale.Sale;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sale> purchases;

    public Customer() {
    }

    public Customer(Integer id, String name, String email, List<Sale> purchases) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.purchases = purchases;
    }

    public Customer(String name, String email, List<Sale> purchases) {
        this.name = name;
        this.email = email;
        this.purchases = purchases;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Sale> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Sale> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", purchases=" + purchases +
                '}';
    }
}
