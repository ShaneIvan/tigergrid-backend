package com.example.tigergrid.controller;

import com.example.tigergrid.model.Form.Question;
import com.example.tigergrid.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/create")
    public Question create(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }
}

