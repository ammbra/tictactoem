package com.example.player;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Component
public class PlayerDetailsService {

	public static final String USER_AUTHORITY = "USER";

//	public static final PasswordEncoder CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();


	private final PlayerRepository repository;

	@Autowired
	public PlayerDetailsService(PlayerRepository repository) {
		this.repository = repository;
	}

	public Player loadUserByUsername(String username) throws NoSuchElementException {
		Player player = repository.findByUsername(username);
		if (Objects.isNull(player)) {
			throw new NoSuchElementException(String.format("Invalid username: %s", username));
		}

//		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(USER_AUTHORITY);
		return player;
	}

	public Player extractPlayer(Principal principal) {
		Player player = repository.findByUsername(principal.getName());
		if (Objects.isNull(player)) {
			throw new NoSuchElementException(String.format("Invalid username: %s", principal.getName()));
		}
		return player;
	}

	public Player save(Player player) {
		String encodedPassword = Base64.getEncoder().encodeToString(player.getPassword().getBytes());
		player.setType(Player.Type.HUMAN);
		player.setPassword(encodedPassword);
		return repository.save(player);
	}
}