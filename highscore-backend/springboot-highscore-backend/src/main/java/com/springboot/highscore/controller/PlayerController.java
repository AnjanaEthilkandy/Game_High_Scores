package com.springboot.highscore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.highscore.entity.Player;
import com.springboot.highscore.exception.ResourceNotFoundException;
import com.springboot.highscore.repository.PlayerRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/players/{category}")
	public List<Player> getPlayersByCategory(@PathVariable String category) {
		if(category == "") {
			throw new ResourceNotFoundException("Resource not found");
		}
		if(category.equalsIgnoreCase("OverAll")) {
			return playerRepository.findTop10ByOrderByScoreDesc();
		} else {
			return playerRepository.findTop10ByCategoryContainingIgnoreCaseOrderByScoreDesc(category);		
		}	
	}
	
	@GetMapping("/players")
	public List<Player> getAllPlayers(){
		return playerRepository.findAll();
	}
}
