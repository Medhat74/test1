package game;

import static java.lang.StrictMath.abs;

public class Rook extends Piece {

    protected boolean firstMove = false;

    Rook(int row , int col , boolean white){
        super(row , col , white);
    }




    @Override
    protected boolean isValid(int x, int y, boolean[][] isWhitFree, boolean[][] isBlackFree) {
        if (x == super.getRow() ) {
            if (y > super.getCol()) {
                for (int j = super.getCol() + 1; j <= y; j++) {
                    if (!isWhitFree[super.getRow()][j]) {
                        return false;
                    }

                }
            }
            else  {
                for (int j = y; j <= super.getCol() -1; j++) {
                    if (!isWhitFree[super.getRow()][j]) {
                        return false;
                    }

                }
            }
            return true;
        }
        else if (y == super.getCol()){
            if (x > super.getRow()) {
                for (int i = super.getRow() + 1; i <= abs(x); i++) {
                    if (!isWhitFree[i][super.getCol()]) {
                        return false;
                    }

                }
            }
            else {
                for (int i = x; i <= super.getRow()-1 ; i++) {
                    if (!isWhitFree[i][super.getCol()]) {
                        return false;
                    }

                }
            }
            return true;
        }

        return false;
    }
}