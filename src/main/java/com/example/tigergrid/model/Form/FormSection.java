package com.example.tigergrid.model.Form;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FormSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    @JsonBackReference
    private Form form;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dropdown> dropdowns;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Question> questions;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CustomAnswer> customAnswers;

    // Getters and setters
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

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public List<Dropdown> getDropdowns() {
        return dropdowns;
    }

    public void setDropdowns(List<Dropdown> dropdowns) {
        this.dropdowns = dropdowns;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<CustomAnswer> getCustomAnswers() {
        return customAnswers;
    }

    public void setCustomAnswers(List<CustomAnswer> customAnswers) {
        this.customAnswers = customAnswers;
    }
}
