package game;

public class Queen extends Piece{
    Rook rook ;
    Bishop bishop ;

    Queen (int row , int col , boolean white){
        super(row , col , white);
    }

    @Override
    protected boolean isValid(int x, int y, boolean[][] isWhitFree, boolean[][] isBlackFree) {
        rook = new Rook(getRow() , getCol() ,getWhite());
        bishop = new Bishop(getRow() , getCol() , getWhite());

        return rook.isValid(x, y, isWhitFree, isBlackFree) || bishop.isValid(x, y, isWhitFree, isBlackFree); //return true if

    }
}
