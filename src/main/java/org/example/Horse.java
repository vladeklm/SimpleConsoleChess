package org.example;

public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)
                && (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2
                || Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1);
        return result;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
