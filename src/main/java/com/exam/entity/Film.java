package com.exam.entity;

public class Film {
    private int filmId;
    private String title;
    private String description;
    int langusgeId;
    private String name;
    private Language language;

    public Film() {
    }

    public Film(int filmId, String title, String description, String name){
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.name = language.getName();
    }

    public Film(String title, String description, int langusgeId) {
        this.title = title;
        this.description = description;
        this.langusgeId = langusgeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLangusgeId() {
        return langusgeId;
    }

    public void setLangusgeId(int langusgeId) {
        this.langusgeId = langusgeId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
