package com.example.portalspolecznosciowy.controllers.helpingClasses;

import java.util.Date;

public class HelpingClass2 {
    private String nickname;
    private String description;
    private Date date;

    public HelpingClass2(String nickname, String description, Date date) {
        this.nickname = nickname;
        this.description = description;
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
