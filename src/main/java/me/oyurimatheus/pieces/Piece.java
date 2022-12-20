package me.oyurimatheus.pieces;

public interface Piece {

    boolean canMoveTo(Coordinate coordinate);


    String moveTo(Coordinate coordinate, Board board);

    boolean canPromoteTo(PieceType piece);

    boolean isSameColor(Piece piece);

    Coordinate getPosition();

    Color color();

    boolean nullSpot();

}
