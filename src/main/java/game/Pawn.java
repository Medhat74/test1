package game;

public class Pawn extends Piece{

    Pawn(int row , int col , boolean white ){
        super(row , col , white);
    }

    @Override
    protected boolean isValid(int x, int y, boolean[][] isWhitFree, boolean[][] isBlackFree) {
        System.out.println("iam in is valid");
        System.out.println("x = " + x + " & row = " +getRow());
        System.out.println("y = " + y + " & col = " +getCol());
        System.out.println(isWhitFree[x][y] + " " + isBlackFree[x][y]);
        if (y == getCol()-1 && getWhite() && isWhitFree[x][y] && isBlackFree[x][y] && x == getRow()){
            return true;
        }
        else if (y == getCol()+1 && !getWhite() && isWhitFree[x][y] && isBlackFree[x][y] && x == getRow()){
            return true;
        }
        else if (y == getCol()-2 && getWhite() && isWhitFree[x][y] && x == getRow() && getCol() == 6){
            return true;
        }
        else if ((Math.abs(y - getCol()) ==1) && (!getWhite() && !isWhitFree[x][y]) && (Math.abs(x -getRow()) == 1)){
            return true;
        }
        else if ((Math.abs(y - getCol()) ==1) && (getWhite() && !isBlackFree[x][y]) && (Math.abs(x -getRow()) == 1)){
            return true;
        }

        else {
            System.out.println("iam in else");
            return y == getCol() + 2 && !getWhite() && isWhitFree[x][y] && x == getRow() && getCol() == 1;
        }
    }
}