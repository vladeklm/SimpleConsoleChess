package org.example;

public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }
    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)
                && (Math.abs(line - toLine) == 0 || Math.abs(column - toColumn) == 0 || Math.abs(line - toLine) == Math.abs(column - toColumn))
                && super.isWayFree(chessBoard, line, column, toLine, toColumn);
        return result;
    }
}
