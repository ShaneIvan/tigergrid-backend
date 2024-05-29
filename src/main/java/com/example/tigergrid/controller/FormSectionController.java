package com.example.tigergrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tigergrid.service.FormSectionService;

@RestController
@RequestMapping("/form-sections")
@CrossOrigin
public class FormSectionController {

    @Autowired
    private FormSectionService formSectionService;

    @PostMapping("/{formSectionId}/dropdowns/{questionId}")
    public void addQuestionToFormSection_Dropdowns(@PathVariable int formSectionId, @PathVariable int questionId) {
        formSectionService.addQuestionToFormSection_Dropdowns(formSectionId, questionId);
    }

    @PostMapping("/{formSectionId}/questions/{questionId}")
    public void addQuestionToFormSection_Questions(@PathVariable int formSectionId, @PathVariable int questionId) {
        formSectionService.addQuestionToFormSection_Questions(formSectionId, questionId);
    }

    @PostMapping("/{formSectionId}/custom_answers/{questionId}")
    public void addQuestionToFormSection_CustomAnswers(@PathVariable int formSectionId, @PathVariable int questionId) {
        formSectionService.addQuestionToFormSection_CustomAnswers(formSectionId, questionId);
    }
}