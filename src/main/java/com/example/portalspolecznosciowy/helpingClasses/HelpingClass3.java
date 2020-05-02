package com.example.portalspolecznosciowy.helpingClasses;

import java.util.Date;

public class HelpingClass3 {

    private long photo_id;
    private Date date;
    private String description;
    private String tags;
    private long user_id;
    private String name_photo;
    private String source;
    private String nickname;

    public HelpingClass3(long photo_id, Date date, String description, String tags, String name_photo, String source,String nickname) {
        this.photo_id = photo_id;
        this.date = date;
        this.description = description;
        this.tags = tags;
        this.name_photo = name_photo;
        this.source = source;
        this.nickname = nickname;
    }

    public long getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(long photo_id) {
        this.photo_id = photo_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName_photo() {
        return name_photo;
    }

    public void setName_photo(String name_photo) {
        this.name_photo = name_photo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
