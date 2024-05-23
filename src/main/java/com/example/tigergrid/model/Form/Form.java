package com.example.tigergrid.model.Form;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private boolean visible;
    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, FormSection> sections;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Map<Integer, FormSection> getSections() {
        return sections;
    }

    public void setSections(Map<Integer, FormSection> sections) {
        this.sections = sections;
    }
}
