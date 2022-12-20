package me.oyurimatheus.pieces;

public enum PieceType {
    PAWN(""),
    ROOK("R"),
    KNIGHT("N"),
    BISHOP("B"),
    QUEEN("Q"),
    KING("K");

    private final String notation;


    PieceType(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }
}
