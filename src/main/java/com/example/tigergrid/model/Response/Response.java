package com.example.tigergrid.model.Response;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String formTitle = "";
    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, ResponseSection> sections;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public Map<Integer, ResponseSection> getSections() {
        return sections;
    }

    public void setSections(Map<Integer, ResponseSection> sections) {
        this.sections = sections;
    }
}
