package com.guizao.Chatbot_t1.service;

import com.guizao.Chatbot_t1.model.QA;
import com.guizao.Chatbot_t1.repository.QARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QAService {
    @Autowired
    private QARepository repository;

    public List<QA> findAll() {
        return repository.findAll();
    }

    public Optional<QA> findById(Long id) {
        return repository.findById(id);
    }

    public QA save(QA qa) {
        return repository.save(qa);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
