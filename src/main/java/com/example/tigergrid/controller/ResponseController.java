package com.example.tigergrid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tigergrid.model.Response.*;

import com.example.tigergrid.service.ResponseService;

@RestController
@RequestMapping("/response")
@CrossOrigin
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PostMapping("/uploadCustomAnswer")
    public ResponseEntity<String> uploadAnswer(@RequestBody String answer) {
        responseService.uploadAnswer(answer);
        return ResponseEntity.ok("Answer uploaded successfully");
    }

    @PostMapping("/save")
    public void saveResponseAnswer(@RequestBody int custom_answerId, @RequestParam int questionId) {
        responseService.saveResponseAnswer(custom_answerId, questionId);
    }

    @PostMapping("/saveAll/{questionId}/{userId}")
    public void saveUserResponse(@RequestBody String answer, @PathVariable String questionId, @PathVariable String userId) {

        // first that should happen is create custom_answer
        responseService.uploadAnswer(answer);

        // get custom_answer_id
        int custom_answerId = responseService.getLastInsertId();

        // save response_answer
        responseService.saveResponseAnswer(custom_answerId, Integer.parseInt(questionId));

        // save response
        responseService.saveResponse(answer);

        int responseId = responseService.getLastInsertId();

        // save user_response
        responseService.saveUserResponse(responseId, Integer.parseInt(userId));

    }
}
