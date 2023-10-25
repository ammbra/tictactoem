package com.example.player;

import io.micronaut.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByUsername(String username);
}