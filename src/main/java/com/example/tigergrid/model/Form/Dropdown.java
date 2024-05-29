package com.example.tigergrid.model.Form;

import jakarta.persistence.Entity;

@Entity
public class Dropdown extends Question {
    private String placeholder;

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }
}
