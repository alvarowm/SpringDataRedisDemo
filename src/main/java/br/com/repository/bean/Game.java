package br.com.repository.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.transaction.annotation.Transactional;

@RedisHash("Game")
@Transactional
public class Game implements Serializable {

	private static final long serialVersionUID = 3257281193238247785L;

	public enum Tipo {
		ACAO, CORRIDA, RPG, FPS, TPS, DOISD, AVENTURA
	}

	private String id;
	private String name;
	private Tipo tipo;
	private BigDecimal value;
	@TimeToLive
	private long expiration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Game(String id, String name, Tipo tipo, BigDecimal value) {
		super();
		this.id = id;
		this.name = name;
		this.tipo = tipo;
		this.value = value;
		this.expiration = (1L * value.intValue()) / 10;
	}

	public Game() {
		super();
	}
}
