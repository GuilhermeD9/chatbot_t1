package com.guizao.Chatbot_t1.controller;

import com.guizao.Chatbot_t1.model.QA;
import com.guizao.Chatbot_t1.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qa")
public class QAController {
    @Autowired
    private QAService service;

    @GetMapping
    public List<QA> getAllQAs() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QA> getQAById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public QA createQA(@RequestBody QA qa) {
        return service.save(qa);
    }

    public ResponseEntity<QA> updateQA(@PathVariable Long id, @RequestBody QA qa) {
        return service.findById(id)
                .map(existingQA -> {
                    existingQA.setQuestion(qa.getQuestion());
                    existingQA.setAnswer(qa.getAnswer());
                    return ResponseEntity.ok(service.save(existingQA));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteQA(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
