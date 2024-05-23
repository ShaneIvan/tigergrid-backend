package com.example.tigergrid.model.Form;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class FormSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, Dropdown> dropdowns;
    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, Question> questions;
    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, CustomAnswer> customAnswers;

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

    public Map<Integer, Dropdown> getDropdowns() {
        return dropdowns;
    }

    public void setDropdowns(Map<Integer, Dropdown> dropdowns) {
        this.dropdowns = dropdowns;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<Integer, Question> questions) {
        this.questions = questions;
    }

    public Map<Integer, CustomAnswer> getCustomAnswers() {
        return customAnswers;
    }

    public void setCustomAnswers(Map<Integer, CustomAnswer> customAnswers) {
        this.customAnswers = customAnswers;
    }
}
