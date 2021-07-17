package game;

public class Knight extends Piece{


    Knight(int row , int col , boolean white){
        super(row , col , white);

    }

    @Override
    protected boolean isValid(int x, int y, boolean[][] isWhitFree, boolean[][] isBlackFree) {
        int deltaRow = Math.abs(x - getRow()) , deltaCol = Math.abs(y - getCol());
        return ( (deltaRow == 1 && deltaCol == 2) || (deltaRow == 2 && deltaCol == 1) ) &&
                ( (isWhitFree[x][y] && getWhite()) || (isBlackFree[x][y] && !getWhite()) );

    }
}
