package com.example.tigergrid.model.Response;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class ResponseSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, ResponseAnswer> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String responseSection) {
        this.title = responseSection;
    }

    public Map<Integer, ResponseAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, ResponseAnswer> answers) {
        this.answers = answers;
    }
}
