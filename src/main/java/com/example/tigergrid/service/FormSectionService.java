package com.example.tigergrid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class FormSectionService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void addQuestionToFormSection_Dropdowns(int formSectionId, int questionId) {
        String sql = "INSERT INTO form_section_dropdowns (form_section_id, dropdowns_id) VALUES (:formSectionId, :questionId)";
        entityManager.createNativeQuery(sql)
                .setParameter("formSectionId", formSectionId)
                .setParameter("questionId", questionId)
                .executeUpdate();
    }

    @Transactional
    public void addQuestionToFormSection_Questions(int formSectionId, int questionId) {
        String sql = "INSERT INTO form_section_questions (form_section_id, questions_id) VALUES (:formSectionId, :questionId)";
        entityManager.createNativeQuery(sql)
                .setParameter("formSectionId", formSectionId)
                .setParameter("questionId", questionId)
                .executeUpdate();
    }

    @Transactional
    public void addQuestionToFormSection_CustomAnswers(int formSectionId, int questionId) {
        String sql = "INSERT INTO form_section_custom_answers (form_section_id, custom_answers_id) VALUES (:formSectionId, :questionId)";
        entityManager.createNativeQuery(sql)
                .setParameter("formSectionId", formSectionId)
                .setParameter("questionId", questionId)
                .executeUpdate();
    }
}