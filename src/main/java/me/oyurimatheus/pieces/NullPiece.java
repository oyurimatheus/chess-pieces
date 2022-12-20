package me.oyurimatheus.pieces;


import java.util.StringJoiner;

public class NullPiece implements Piece {

    private Coordinate position;

    public NullPiece(Coordinate position) {
        this.position = position;
    }

    @Override
    public boolean canMoveTo(Coordinate coordinate) {
        return false;
    }

    @Override
    public String moveTo(Coordinate coordinate, Board board) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean canPromoteTo(PieceType piece) {
        return false;
    }

    @Override
    public boolean isSameColor(Piece piece) {
        return false;
    }

    @Override
    public Coordinate getPosition() {
        return position;
    }

    @Override
    public Color color() {
        return null;
    }

    @Override
    public boolean nullSpot() {
        return true;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NullPiece.class.getSimpleName() + "[", "]")
                .add("position=" + position)
                .toString();
    }
}
