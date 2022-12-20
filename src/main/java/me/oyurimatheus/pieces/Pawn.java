package me.oyurimatheus.pieces;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

import static me.oyurimatheus.pieces.PieceType.*;
import static me.oyurimatheus.pieces.PieceType.QUEEN;

public class Pawn implements Piece {

    private static final Set<PieceType> POSSIBLE_PROMOTIONS = Set.of(ROOK, KNIGHT, BISHOP, QUEEN);

    private final PieceType type = PAWN;

    private Coordinate position;
    private Color color;

    private boolean firstMove = true;

    public Pawn(Coordinate coordinate, Color color) {
        this.position = coordinate;
        this.color = color;
    }

    @Override
    public boolean canMoveTo(Coordinate coordinate) {

        if (position.equals(coordinate)) {
            return false;
        }

        int distance = Math.abs(coordinate.line().notation() - position.line().notation());

        if (firstMove && distance <= 2
                      && coordinate.column().equals(position.column())) {
            return true;
        }

        return distance == 1
                && coordinate.column().equals(position.column());

    }

    @Override
    public String moveTo(Coordinate coordinate, Board board) {

        if (board.hasPiece(coordinate)) {
            var notation = this.position.column().notation() + "x" + coordinate.notation();

            this.position = coordinate;
            board.updatePosition(coordinate, this);

            return notation;
        }

        this.position = coordinate;
        board.updatePosition(coordinate, this);

        return position.notation();
    }

    @Override
    public boolean canPromoteTo(PieceType piece) {

        return position.isPromotingPosition(color) && POSSIBLE_PROMOTIONS.contains(piece);

    }

    @Override
    public boolean isSameColor(Piece piece) {
        return this.color == piece.color();
    }

    @Override
    public boolean nullSpot() {
        return false;
    }

    @Override
    public Coordinate getPosition() {
        return position;
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return position.equals(pawn.position) && color == pawn.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, color);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pawn.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("position=" + position)
                .add("color=" + color)
                .add("firstMove=" + firstMove)
                .toString();
    }
}
