package org.example;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
                board[endLine][endColumn].setCheck();
                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        if (this.nowPlayerColor().equals("White"))
            return castling(0, 0, 0, 4);
        else
            return castling(7, 0, 7, 4);
    }

    public boolean castling7() {
        if (this.nowPlayerColor().equals("White"))
            return castling(0, 7, 0, 4);
        else
            return castling(7, 7, 7, 4);
    }

    private boolean castling(int xR, int yR, int xK, int yK) {
        boolean result = board[xR][yR] != null && board[xR][yR].getSymbol().equals("R") && board[xR][yR].isCheck()
                && board[xK][yK] != null && board[xK][yK].getSymbol().equals("K") && board[xK][yK].isCheck();
        if (result) {
            int start = Math.min(yR, yK);
            int finish = Math.max(yR, yK);
            outerloop:
            for (int i = start + 1; i < finish; i++) {
                for(int x= 0; x < 8; x++) {
                    for(int y = 0; y < 8; y++) {
                        if(board[x][y] != null && !board[x][y].getColor().equals(this.nowPlayerColor())) {
                            result = result && !board[x][y].canMoveToPosition(this, x, y, xR, i);
                        }
                        if (!result) {
                            break outerloop;
                        }
                    }
                }
            }
        }
        if (result) {
            if (xR < xK) {
                board[xK-1][yK] = board[xR][yR];
                board[xK-2][yK] = board[xK][yK];
            }
            else {
                board[xK+1][yK] = board[xR][yR];
                board[xK+2][yK] = board[xK][yK];
            }
            board[xR][yR] = null;
            board[xK][yK] = null;
        }
        return result;
    }
}
