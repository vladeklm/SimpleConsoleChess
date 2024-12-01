package org.example;

public class Pawn  extends ChessPiece {


    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)
                && chessBoard.board[toLine][toColumn] == null ?
                ((Math.abs(line - toLine) == 1 || (Math.abs(line - toLine) == 2) && (line == 1 || line == 6)) && column - toColumn == 0)
                : (Math.abs(column - toColumn) == 1 && Math.abs(line - toLine) == 1);
        return result;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
