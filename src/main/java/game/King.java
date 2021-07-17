package game;

public class King extends Piece {

    protected boolean firstMove = false, doCastling = false, castled = false;
    protected boolean castlingRook0 = false, castlingRook1 = false;
    King(int row , int col ,boolean white){
        super(row , col , white);
    }


    @Override
    protected boolean isValid(int x, int y, boolean[][] isWhitFree, boolean[][] isBlackFree) {
        int deltaRow = Math.abs(x - getRow()) , deltaCol = Math.abs(y - getCol());
        if (((deltaRow == 1 && deltaCol == 0 ) || (deltaRow == 0 && deltaCol == 1 )||
                (deltaRow == 1 && deltaCol == 1 )) && ((isWhitFree[x][y] && getWhite()) || (!getWhite() && isBlackFree[x][y]) ) ){
            doCastling = false;
            return true;
        }
       

        if (castled == false){
            
            if ( firstMove == false && ((x - getRow() == 3 ||x - getRow() == 2 ) && deltaCol == 0)){
                castlingRook1 = true;
                doCastling = true;
                return true;
            }
            else if ( firstMove == false && ((getRow() - x == 4 || getRow() - x == 3) && deltaCol == 0 )){
                castlingRook0 = true;
                doCastling = true;
                return true;
            }
            else System.out.println("invalid castling");
        }
         
        
        return false;
    }

}