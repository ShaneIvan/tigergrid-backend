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

import com.example.tigergrid.model.Form.Question;
import com.example.tigergrid.model.Form.TextQuestion;
import com.example.tigergrid.service.QuestionService;

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

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }

    @GetMapping("/getByForm/{formId}")
    public List<Question> getByForm(@PathVariable int formId) {
        return questionService.getQuestionsByForm(formId);
    }

    @GetMapping("/getAll")
    public List<Question> getAll() {
        return questionService.getAllQuestions();
    }

    @PutMapping("/update")
    public Question update(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    @PostMapping("/submitAll")
    public String submitAll(@RequestBody List<Question> questions) {
        questionService.saveAllQuestions(questions);
        return "All questions submitted successfully!";
    }

    // @PostMapping("/submitText")
    // public TextQuestion submitText(@RequestBody TextQuestion textQuestion) {
    //     return questionService.saveTextQuestion(textQuestion);
    // }
}
