package com.example.portalspolecznosciowy.helpingClasses;

public class HelpingClass4 {
    private String nickname;
    private String name;
    private String surname;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public HelpingClass4(String nickname, String name, String surname, String description) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.description = description;
    }
}
