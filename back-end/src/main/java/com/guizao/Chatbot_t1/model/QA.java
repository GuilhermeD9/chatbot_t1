package com.guizao.Chatbot_t1.model;
//QA = (QUESTIONS AND ANSWERS)
//ESSA CLASSE DEFINE AS PROPRIEDADES QUE SERÃO INSERIDAS NO BD

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QA {
    @Id //Declaração ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerar valor auto
    private Long id;
    private String question;
    private String answer;

    //Constructos, Getters & Setters
    public QA() {}

    public QA(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
