package io.github.dilmi214.artgallery.nova_gallery.artist;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.ArtPiece;

import java.util.List;

public class Artist {
    private Integer id;
    private String name;
    private String bio;
    private List<ArtPiece> artPieces;

    public Artist() {
    }

    public Artist(Integer id, String name, String bio, List<ArtPiece> artPieces) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.artPieces = artPieces;
    }

    public Artist(String name, List<ArtPiece> artPieces, String bio) {
        this.name = name;
        this.artPieces = artPieces;
        this.bio = bio;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<ArtPiece> getArtpieces() {
        return artPieces;
    }

    public void setArtpieces(List<ArtPiece> artPieces) {
        this.artPieces = artPieces;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", artpieces=" + artPieces +
                '}';
    }
}
