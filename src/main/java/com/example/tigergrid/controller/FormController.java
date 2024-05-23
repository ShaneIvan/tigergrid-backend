package com.example.tigergrid.controller;

import com.example.tigergrid.model.Form.Form;
import com.example.tigergrid.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String create(@PathVariable int id) {
        return formService.deleteForm(id);
    }

    @GetMapping("/get/{id}")
    public Form get(@PathVariable int id) {
        return formService.getForm(id);
    }

    @GetMapping("/getAll")
    public List<Form> getAll() {
        return formService.getAllForms();
    }

    @PutMapping("/update")
    public Form update(@RequestBody Form form) {
        return formService.updateForm(form);
    }
}
