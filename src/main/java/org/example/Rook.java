package org.example;

public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)
                && (Math.abs(line - toLine) > 0 ^ Math.abs(column - toColumn) > 0)
                && super.isWayFree(chessBoard, line, column, toLine, toColumn);
        return result;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
