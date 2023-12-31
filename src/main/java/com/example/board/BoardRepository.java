package com.example.board;

import com.example.player.Player;
import io.micronaut.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface BoardRepository extends CrudRepository<Board, Long> {

    Board findFirstByPlayerOrderByIdDesc(Player player);

}