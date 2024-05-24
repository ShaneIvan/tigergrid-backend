package com.example.tigergrid.model.Form;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String newQuestion;
    private String newInputType;
    @ElementCollection
    private List<String> newDropdownChoices;
    private int page;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewQuestion() {
        return newQuestion;
    }

    public void setNewQuestion(String newQuestion) {
        this.newQuestion = newQuestion;
    }

    public String getNewInputType() {
        return newInputType;
    }

    public void setNewInputType(String newInputType) {
        this.newInputType = newInputType;
    }

    public List<String> getNewDropdownChoices() {
        return newDropdownChoices;
    }

    public void setNewDropdownChoices(List<String> newDropdownChoices) {
        this.newDropdownChoices = newDropdownChoices;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
