package com.example.tigergrid.service;

import com.example.tigergrid.model.Form.Form;
import com.example.tigergrid.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    public String deleteForm(int id) {
        formRepository.deleteById(id);
        return "Form with ID " + id + " successfully deleted!";
    }

    public Form saveForm(Form form) {
        return formRepository.save(form);
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
}
