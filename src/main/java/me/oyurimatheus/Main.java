package me.oyurimatheus;

import me.oyurimatheus.pieces.Board;
import me.oyurimatheus.pieces.Coordinate;

import java.util.Optional;

import static me.oyurimatheus.pieces.Coordinate.Column.E;
import static me.oyurimatheus.pieces.Coordinate.Line.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        var e4 = board.makeMove(new Coordinate(E, TWO), new Coordinate(E, FOUR));
        e4.ifPresent(System.out::println);

        var e5 = board.makeMove(new Coordinate(E, SEVEN), new Coordinate(E, FIVE));
        e5.ifPresent(System.out::println);


    }
}