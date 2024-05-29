package com.example.tigergrid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tigergrid.model.Form.Form;
import com.example.tigergrid.service.FormService;

@RestController
@RequestMapping("/form")
@CrossOrigin
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/create")
    public Form create(@RequestBody Form form) {
        return formService.saveForm(form);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return formService.deleteForm(id);
    }

    @GetMapping("/get/{id}")
    public Form get(@PathVariable int id) {
        return formService.getForm(id);
    }

    @GetMapping("/getFormWithQuestions/{formId}")
    public Form getFormWithQuestions(@PathVariable int formId) {
        return formService.getFormWithQuestions(formId);
    }


    @GetMapping("/getAll")
    public List<Form> getAll() {
        return formService.getAllForms();
    }

    @PutMapping("/update")
    public Form update(@RequestBody Form form) {
        return formService.updateForm(form);
    }

    @PutMapping("/hide/{id}")
    public Form hideForm(@PathVariable int id) {
        return formService.hideForm(id);
    }

    @PutMapping("/show/{id}")
    public Form showForm(@PathVariable int id) {
        return formService.showForm(id);
    }

    @PostMapping("/submitAll")
    public String submitAll(@RequestBody List<Form> forms) {
        formService.saveAllForms(forms);
        return "All forms submitted successfully!";
    }
}
