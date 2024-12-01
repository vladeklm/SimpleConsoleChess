package org.example;

import java.util.Objects;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)
                && Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1;
        return result;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        boolean result = false;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (board.board[i][j] != null && board.board[i][j].getColor().equals(board.nowPlayerColor())) {
                    result = result || board.board[i][j].canMoveToPosition(board, i, j, line, column);
                }
        return result;
    }
}
