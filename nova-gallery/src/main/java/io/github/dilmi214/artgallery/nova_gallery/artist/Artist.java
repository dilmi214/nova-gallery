package io.github.dilmi214.artgallery.nova_gallery.artist;

import io.github.dilmi214.artgallery.nova_gallery.artpiece.Artpiece;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private Integer id;
    private String name;
    private String bio;
    private List<Artpiece> artpieces;

    public Artist() {
    }

    public Artist(Integer id, String name, String bio, List<Artpiece> artpieces) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.artpieces = artpieces;
    }

    public Artist(String name, List<Artpiece> artpieces, String bio) {
        this.name = name;
        this.artpieces = artpieces;
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

    public List<Artpiece> getArtpieces() {
        return artpieces;
    }

    public void setArtpieces(List<Artpiece> artpieces) {
        this.artpieces = artpieces;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", artpieces=" + artpieces +
                '}';
    }
}
