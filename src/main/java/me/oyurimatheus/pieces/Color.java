package me.oyurimatheus.pieces;

public enum Color {
    WHITE {

        @Override
        public boolean canPromotePawn(Coordinate coordinate) {
            return coordinate.line().notation() == 8;
        }
    },
    BLACK {

        @Override
        public boolean canPromotePawn(Coordinate coordinate) {
            return coordinate.line().notation() == 1;
        }
    };

    public abstract boolean canPromotePawn(Coordinate coordinate);
}
