package org.example;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)
                && (Math.abs(line - toLine) == Math.abs(column - toColumn))
                && super.isWayFree(chessBoard, line, column, toLine, toColumn);
        return result;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
