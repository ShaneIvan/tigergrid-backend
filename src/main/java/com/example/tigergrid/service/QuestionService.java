package com.example.tigergrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tigergrid.model.Form.Question;
import com.example.tigergrid.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getQuestionsByForm(int formId) {
        return questionRepository.findByFormId(formId);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public String deleteQuestion(int id) {
        questionRepository.deleteById(id);
        return "Question removed " + id;
    }

    public void saveAllQuestions(List<Question> questions) {
        questionRepository.saveAll(questions);
    }
}
