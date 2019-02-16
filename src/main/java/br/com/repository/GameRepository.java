package br.com.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.repository.bean.Game;

@Repository
@Transactional
public class GameRepository {

	@Autowired
	private RedisTemplate<Game.Tipo, Game> redisTemplate;

	private void inserir(Game game) {
		redisTemplate.opsForList().leftPush(game.getTipo(), game);
	}

	private Game recuperar(Game.Tipo tipo) {
		return redisTemplate.opsForList().leftPop(tipo);
	}

	private void excluir(Game.Tipo tipo) {
		redisTemplate.opsForList().leftPop(tipo);
	}

	public void rodarExemplos() {
		inserir(new Game("gears4", "gears of war 4", Game.Tipo.TPS, new BigDecimal(50)));
		inserir(new Game("spiderPS4", "spider", Game.Tipo.ACAO, new BigDecimal(200)));
		inserir(new Game("ninokuni", "Ni No Kuni 2", Game.Tipo.RPG, new BigDecimal(140)));
		inserir(new Game("sonic", "Sonic Heroes", Game.Tipo.DOISD, new BigDecimal(20)));
		inserir(new Game("mario", "Mario Odyssey", Game.Tipo.AVENTURA, new BigDecimal(300)));
		inserir(new Game("COD", "Call of Duty®: WWII", Game.Tipo.FPS, new BigDecimal(80)));
		System.out.println("Número de jogos de aventura: " + redisTemplate.opsForList().size(Game.Tipo.AVENTURA));
		inserir(new Game("mario", "Mario 64", Game.Tipo.AVENTURA, new BigDecimal(100)));
		System.out.println("Número de jogos de aventura: " + redisTemplate.opsForList().size(Game.Tipo.AVENTURA));
		inserir(new Game("mario", "Super Mario World", Game.Tipo.AVENTURA, new BigDecimal(100)));
		System.out.println("Número de jogos de aventura: " + redisTemplate.opsForList().size(Game.Tipo.AVENTURA));
		excluir(Game.Tipo.AVENTURA);
		System.out.println("Número de jogos de aventura: " + redisTemplate.opsForList().size(Game.Tipo.AVENTURA));
		System.out.println("O preço é " + recuperar(Game.Tipo.DOISD).getValue() + ".");
	}
}
