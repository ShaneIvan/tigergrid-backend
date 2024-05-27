package com.example.tigergrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tigergrid.model.Form.Form; // Make sure to import the Form class
import com.example.tigergrid.model.Form.Question;
import com.example.tigergrid.repository.FormRepository;
import com.example.tigergrid.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FormRepository formRepository;

    public Question saveQuestion(Question question) {
        if (question.getForm() != null && question.getForm().getId() != 0) {
            Form form = formRepository.findById(question.getForm().getId()).orElse(null);
            if (form != null) {
                question.setForm(form);
            }
        }
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
        questions.forEach(question -> {
            if (question.getForm() != null && question.getForm().getId() != 0) {
                Form form = formRepository.findById(question.getForm().getId()).orElse(null);
                if (form != null) {
                    question.setForm(form);
                }
            }
        });
        questionRepository.saveAll(questions);
    }
}
