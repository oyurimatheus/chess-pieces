package me.oyurimatheus.pieces;

import java.util.*;
import java.util.stream.Collectors;

public class Board {

    private final HashMap<Coordinate, Piece> board = new HashMap<>();

    private final Set<Piece> blackPieces = new HashSet<>();
    private final Set<Piece> whitePieces = new HashSet<>();

    public Board() {

        var coordinates = Arrays.stream(Coordinate.Column.values())
                            .flatMap(column -> Arrays.stream(Coordinate.Line.values())
                            .map(line -> new Coordinate(column, line)))
                            .collect(Collectors.toSet());


        for (var position : coordinates) {
            board.put(position, new NullPiece(position));
        }

        List<Coordinate> whitePawsInitialCoordinates = Arrays.stream(Coordinate.Column.values())
                                                             .map(column -> new Coordinate(column, Coordinate.Line.TWO))
                                                             .toList();

        List<Coordinate> blackPawsInitialCoordinates = Arrays.stream(Coordinate.Column.values())
                                                             .map(column -> new Coordinate(column, Coordinate.Line.SEVEN))
                                                             .toList();



        blackPawsInitialCoordinates.forEach(coordinate -> {
            Pawn pawn = new Pawn(coordinate, Color.BLACK);
            blackPieces.add(pawn);
            board.put(coordinate, pawn);
        });

//        blackPieces.add(new Rook(new Coordinate(Coordinate.Column.A, Coordinate.Line.EIGHT), Color.BLACK));
//        blackPieces.add(new Rook(new Coordinate(Coordinate.Column.H, Coordinate.Line.EIGHT), Color.BLACK));
//        blackPieces.add(new Knight(new Coordinate(Coordinate.Column.B, Coordinate.Line.EIGHT), Color.BLACK));
//        blackPieces.add(new Knight(new Coordinate(Coordinate.Column.G, Coordinate.Line.EIGHT), Color.BLACK));
//        blackPieces.add(new Bishop(new Coordinate(Coordinate.Column.C, Coordinate.Line.EIGHT), Color.BLACK));
//        blackPieces.add(new Bishop(new Coordinate(Coordinate.Column.F, Coordinate.Line.EIGHT), Color.BLACK));
//        blackPieces.add(new Queen(new Coordinate(Coordinate.Column.D, Coordinate.Line.EIGHT), Color.BLACK));
//        blackPieces.add(new King(new Coordinate(Coordinate.Column.E, Coordinate.Line.EIGHT), Color.BLACK));


        for (var piece : blackPieces) {
            board.put(piece.getPosition(), piece);
        }


        whitePawsInitialCoordinates.forEach(coordinate -> {
            whitePieces.add(new Pawn(coordinate, Color.WHITE));
        });
//        whitePieces.add(new Rook(new Coordinate(Coordinate.Column.A, Coordinate.Line.ONE), Color.WHITE));
//        whitePieces.add(new Rook(new Coordinate(Coordinate.Column.H, Coordinate.Line.ONE), Color.WHITE));
//        whitePieces.add(new Knight(new Coordinate(Coordinate.Column.B, Coordinate.Line.ONE), Color.WHITE));
//        whitePieces.add(new Knight(new Coordinate(Coordinate.Column.G, Coordinate.Line.ONE), Color.WHITE));
//        whitePieces.add(new Bishop(new Coordinate(Coordinate.Column.C, Coordinate.Line.ONE), Color.WHITE));
//        whitePieces.add(new Bishop(new Coordinate(Coordinate.Column.F, Coordinate.Line.ONE), Color.WHITE));
//        whitePieces.add(new Queen(new Coordinate(Coordinate.Column.D, Coordinate.Line.ONE), Color.WHITE));
//        whitePieces.add(new King(new Coordinate(Coordinate.Column.E, Coordinate.Line.ONE), Color.WHITE));

        for (var piece : whitePieces) {
            board.put(piece.getPosition(), piece);
        }

    }

    public Optional<String> makeMove(Coordinate from, Coordinate to) {
        var pieceFrom = board.get(from);

        if (!pieceFrom.canMoveTo(to)) {
            return Optional.empty();
        }

        var pieceTo = board.get(to);

        if (pieceFrom.isSameColor(pieceTo)) {
            return Optional.empty();
        }

        var notation = pieceFrom.moveTo(pieceTo.getPosition(), this);

        blackPieces.remove(pieceTo);
        whitePieces.remove(pieceTo);

        return Optional.of(notation);

    }

    void updatePosition(Coordinate coordinate, Piece piece) {
        this.board.put(coordinate, piece);
    }

    public boolean hasPiece(Coordinate coordinate) {
        Piece piece = this.board.get(coordinate);

        return !piece.nullSpot();
    }
}
