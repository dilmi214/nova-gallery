package io.github.dilmi214.artgallery.nova_gallery.curator;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPiece;

import java.util.List;

public class Curator {
    private Integer id;
    private String name;
    private String email;
    private List<ArtPiece> managedArtPieces;

    public Curator() {
    }

    public Curator(Integer id, String name, String email, List<ArtPiece> managedArtPieces) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.managedArtPieces = managedArtPieces;
    }

    public Curator(String name, String email, List<ArtPiece> managedArtPieces) {
        this.name = name;
        this.email = email;
        this.managedArtPieces = managedArtPieces;
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

    public List<ArtPiece> getManagedArtPieces() {
        return managedArtPieces;
    }

    public void setManagedArtPieces(List<ArtPiece> managedArtPieces) {
        this.managedArtPieces = managedArtPieces;
    }

    @Override
    public String toString() {
        return "Curator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", managedArtPieces=" + managedArtPieces +
                '}';
    }
}
