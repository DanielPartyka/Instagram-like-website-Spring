package com.example.portalspolecznosciowy.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photo_id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "section_id", nullable = false)
    private Sections sections;
    private Date date;

    @OneToMany(mappedBy = "photos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comments> comments;

    public Photos () {

    }

    public Photos (User user, Sections sections, String tags, String description, Date date) {
        this.user = user;
        this.sections = sections;
        this.tags = tags;
        this.description = description;
        this.date = date;
    }

    public Long getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Long photo_id) {
        this.photo_id = photo_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sections getSections() {
        return sections;
    }

    public void setSections(Sections sections) {
        this.sections = sections;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String tags;
    private String description;

}
