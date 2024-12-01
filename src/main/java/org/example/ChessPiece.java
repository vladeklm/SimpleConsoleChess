package org.example;

public abstract class ChessPiece{
    private String color;
    private boolean check;

    public ChessPiece(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = (line != toLine || column != toColumn)
                && toColumn >= 0 && toColumn <= 7 && toLine >= 0 && toLine <= 7
                && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()));
        return result;
    }

    public boolean isWayFree(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = true;
        if (toColumn == column) {
            for (int i = line + getIncrementDecrement(line, toLine); isConditionTrue(line, toLine, i); i = i + getIncrementDecrement(i, toLine)) {
                if (chessBoard.board[i][column] != null) {
                    result = false;
                    break;
                }
            }
        }
        else if (toLine == line) {
            for (int i = column + getIncrementDecrement(column, toColumn); isConditionTrue(column, toColumn, i); i = i + getIncrementDecrement(i, toColumn)) {
                if (chessBoard.board[i][column] != null) {
                    result = false;
                    break;
                }
            }
        }
        else {
            for (int i = line + getIncrementDecrement(line, toLine), j = column + getIncrementDecrement(column, toColumn) ; isConditionTrue(line, toLine, i); i = i + getIncrementDecrement(i, toLine), j = j + getIncrementDecrement(j, toColumn)) {
                if (chessBoard.board[i][j] != null) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private int getIncrementDecrement(int start, int finish) {
        int result = finish > start ? 1 : -1;
        return result;
    }

    private boolean isConditionTrue(int start, int finish, int index) {
        boolean result = start < finish ? index < finish : index > finish;
        return result;
    }

    public abstract String getSymbol();

    public boolean isCheck(){
        return !check;
    }

    public void setCheck(){
        check = true;
    }
}
