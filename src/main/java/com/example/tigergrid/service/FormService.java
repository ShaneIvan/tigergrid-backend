package com.example.tigergrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tigergrid.model.Form.Form;
import com.example.tigergrid.repository.FormRepository;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;


    public Form saveForm(Form form) {
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
        return formRepository.save(form);
    }

    public void saveAllForms(List<Form> forms) {
        formRepository.saveAll(forms);
    }

}
