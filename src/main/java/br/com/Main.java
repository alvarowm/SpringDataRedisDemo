package br.com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.config.RedisConfig;
import br.com.repository.GameRepository;

public class Main {

	public static void main(String[] args) {
		rodarExemplo();
	}

	private static void rodarExemplo() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(RedisConfig.class);
		context.refresh();
		GameRepository gameRepository = context.getBean(GameRepository.class);
		gameRepository.rodarExemplos();
	}

}
