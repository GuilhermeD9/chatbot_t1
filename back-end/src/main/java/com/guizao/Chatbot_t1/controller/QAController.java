package com.guizao.Chatbot_t1.controller;
//O controller é reponsável pelas funções de CRUD(Get, Put, Delete e Post
//Todas as marcações com @ São parâmetros HTTP

import com.guizao.Chatbot_t1.model.QA;
import com.guizao.Chatbot_t1.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qa") //Caminho da aplicação web
public class QAController {
    @Autowired
    private QAService service;

    @GetMapping //Função de Get | Coleta todos os dados
    public List<QA> getAllQAs() {
        return service.findAll();
    }

    @GetMapping("/{id}") //Função de Get | Por ID
    public ResponseEntity<QA> getQAById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping //Função de Post
    public QA createQA(@RequestBody QA qa) {
        return service.save(qa);
    }

    @PutMapping ({"/{id}"}) //Função de put por ID
    public ResponseEntity<QA> updateQA(@PathVariable Long id, @RequestBody QA qa) {
        return service.findById(id)
                .map(existingQA -> {
                    existingQA.setQuestion(qa.getQuestion());
                    existingQA.setAnswer(qa.getAnswer());
                    return ResponseEntity.ok(service.save(existingQA));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") //Função delete por ID
    public ResponseEntity<Void> deleteQA(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
