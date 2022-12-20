package me.oyurimatheus.pieces;

public record Coordinate(Column column, Line line) {


    public String notation() {
        return column.notation() + line.notation();
    }

    public boolean isPromotingPosition(Color color) {
        return color.canPromotePawn(this);
    }


    public enum Column {
        A("a"),
        B("b"),
        C("c"),
        D("d"),
        E("e"),
        F("f"),
        G("g"),
        H("h");

        private final String notation;

        Column(String notation) {
            this.notation = notation;
        }

        public String notation() {
            return this.notation;
        }
    }

    public enum Line {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8);

        private final int notation;

        Line(int notation) {
            this.notation = notation;
        }

        public int notation() {
            return this.notation;
        }
    }

}
