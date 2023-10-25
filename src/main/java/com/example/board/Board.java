package com.example.board;

import java.util.List;

import com.example.board.cell.Cell;
import com.example.converter.ListConverter;
import com.example.player.Player;
import com.example.player.Player.Type;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.Convert;
import jakarta.persistence.ManyToOne;

@MappedEntity
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Player player;

    private Type next;

    private Status status;

    private Cell option;

    @Convert(converter = ListConverter.class)
    private List<List<String>> lines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Type getNext() {
        return next;
    }

    public void setNext(Type next) {
        this.next = next;
    }

    public Status getStatus() {
        return status;
    }

    public Cell getOption() {
        return option;
    }

    public void setOption(Cell option) {
        this.option = option;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<List<String>> getLines() {
        return lines;
    }

    public void setLines(List<List<String>> lines) {
        this.lines = lines;
    }
}