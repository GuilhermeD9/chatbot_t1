package com.guizao.Chatbot_t1;
//IMPORTANTE
//Para rodar a aplicação, é necessário um bd Postgree com nome chatbotdbt
//No resources>application.propperties tem os dados de login pra vc alterar

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatbotT1Application {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotT1Application.class, args);
	}

}
