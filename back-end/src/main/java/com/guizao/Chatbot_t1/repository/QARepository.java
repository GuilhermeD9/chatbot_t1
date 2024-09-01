package com.guizao.Chatbot_t1.repository;
//Sinceramente eu não entendo muito bem a repository
//Mas até onde eu sei ela traz as funções do JpaRepository<nomemodel, tipomodel>

import com.guizao.Chatbot_t1.model.QA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QARepository extends JpaRepository<QA, Long> {
}
