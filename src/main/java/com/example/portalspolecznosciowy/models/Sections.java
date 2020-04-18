package com.example.portalspolecznosciowy.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sections {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long section_id;
    private String name;

    public Sections(){

    }


    public Sections(String name) {
        this.name = name;
    }

    public long getSection_id() {
        return section_id;
    }

    public void setSection_id(long section_id) {
        this.section_id = section_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photos> photos) {
        this.photos = photos;
    }

    @OneToMany(mappedBy = "sections", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Photos> photos;
}
