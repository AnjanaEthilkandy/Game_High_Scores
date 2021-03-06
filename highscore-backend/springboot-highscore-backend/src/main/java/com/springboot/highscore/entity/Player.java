package com.springboot.highscore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "player_name")
	private String playerName;

	@Column(name = "rank_level")
	private long level;

	@Column(name = "score")
	private long score;

	@Column(name = "category")
	private String category;

	public Player() {

	}

	public Player(long id, String playerName, long level, long score, String category) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.level = level;
		this.score = score;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", level=" + level + ", score=" + score
				+ ", category=" + category + "]";
	}

}
