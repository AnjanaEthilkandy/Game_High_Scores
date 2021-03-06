package com.springboot.highscore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.highscore.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	List<Player> findTop10ByCategoryContainingIgnoreCaseOrderByScoreDesc(String category);

	List<Player> findTop10ByOrderByScoreDesc();

}
