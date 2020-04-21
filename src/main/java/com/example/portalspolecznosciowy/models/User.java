package com.example.portalspolecznosciowy.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private String image_src;
    private String name;
    private String surname;
    @Column(unique=true)
    private String email;
    private String password;
    private String sex;
    private String description;
    private String ROLE = "USER";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Followers> followers;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Photos> photos;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comments> comments;

    public User() {
    }

    public User(String nickname, String image_src, String name, String surname, String email, String password, String sex, String description, String rOLE) {
        this.nickname = nickname;
        this.image_src = image_src;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.description = description;
        ROLE = rOLE;

    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        ROLE = ROLE;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Followers> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Followers> followers) {
        this.followers = followers;
    }

    public Set<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photos> photos) {
        this.photos = photos;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
