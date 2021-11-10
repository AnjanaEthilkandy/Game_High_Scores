package com.springboot.highscore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.highscore.entity.Player;
import com.springboot.highscore.repository.PlayerRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	private Player playerMock;

	@Mock
	private PlayerRepository playerRepository;

	@SuppressWarnings("unchecked")
	@Test
	public void getPlayersByCategoryTest() throws Exception {
		String uri = "/players/defense";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		ObjectMapper objectMapper = new ObjectMapper();
		List<Player> playersList = (List<Player>) objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				Player.class);
		assertTrue(playersList.size() > 0);

	}
}
