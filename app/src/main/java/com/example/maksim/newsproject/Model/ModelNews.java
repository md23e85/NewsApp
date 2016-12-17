package com.example.maksim.newsproject.Model;

/**
 * Created by Maksim on 17.12.2016.
 */

public class ModelNews {

    private String id;
    private String name;
    private String description;
    private String language;
    private String country;
    private String category;
    private ModelNewsImage urlsToLogos;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getlanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ModelNewsImage getUrlsToLogos() {
        return urlsToLogos;
    }

    public void setUrlsToLogos(ModelNewsImage urlsToLogos) {
        this.urlsToLogos = urlsToLogos;
    }
}
