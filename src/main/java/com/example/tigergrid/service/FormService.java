package com.example.tigergrid.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tigergrid.model.Form.Form;
import com.example.tigergrid.model.Form.FormSection;
import com.example.tigergrid.repository.FormRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class FormService {

    private static final Logger logger = LoggerFactory.getLogger(FormService.class);

    @Autowired
    private FormRepository formRepository;


    @PersistenceContext
    private EntityManager entityManager;

    public Form saveForm(Form form) {
        // Ensure sections are properly managed
        for (FormSection section : form.getSections()) {
            section.setForm(form);
        }
        if (form.getId() != 0) {
            // If the form already exists, merge it
            form = entityManager.merge(form);
        }
        return formRepository.save(form);
    }

    public String deleteForm(int id) {
        formRepository.deleteById(id);
        return "Form removed " + id;
    }

    public Form getForm(int id) {
        return formRepository.findById(id).orElse(null);
    }

    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    public Form updateForm(Form form) {
        return saveForm(form);
    }

    public void saveAllForms(List<Form> forms) {
        for (Form form : forms) {
            for (FormSection section : form.getSections()) {
                section.setForm(form);
            }
        }
        formRepository.saveAll(forms);
    }

    public Form hideForm(int id) {
        Form form = formRepository.findById(id).orElse(null);

        if (form != null) {
            form.setVisible(false);
            formRepository.save(form);
        } else {
            logger.warn("Form with id {} not found", id);
        }
        return form;
    }

    public Form showForm(int id) {
        Form form = formRepository.findById(id).orElse(null);

        if (form != null) {
            form.setVisible(true);
            formRepository.save(form);
        } else {
            logger.warn("Form with id {} not found", id);
        }

        return form;
    }

    public Form getFormWithQuestions(int formId) {
        Form form = formRepository.findById(formId).orElse(null);
        if (form != null) {
            form.getSections().forEach(section -> {
                section.getQuestions().size();
                section.getDropdowns().size();
                section.getCustomAnswers().size();
            });
        }
        return form;
    }

}

