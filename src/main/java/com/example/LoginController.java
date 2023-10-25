package com.example;

import com.example.player.Player;
import com.example.player.PlayerDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.NoSuchElementException;

@Controller
public class LoginController {

	public static final String LOGIN = "login";
	public static final String REGISTER = "register";

	private final PlayerDetailsService playerDetailsService;

	@Autowired
	public LoginController(PlayerDetailsService playerDetailsService) {
		this.playerDetailsService = playerDetailsService;
	}


	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return LOGIN;
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return REGISTER;
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(@Valid Player player, Model model) {
		try {
			playerDetailsService.loadUserByUsername(player.getUsername());
			model.addAttribute("invalid", "Username already acquired. Please use another username");
			return REGISTER;
		} catch (NoSuchElementException ex) {
			playerDetailsService.save(player);
			return LOGIN;
		}

	}
}
