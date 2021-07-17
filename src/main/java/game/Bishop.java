package game;

public class Bishop  extends  Piece{

    Bishop (int row , int col , boolean white){
        super(row , col , white);

    }


    @Override
    protected boolean isValid(int x, int y, boolean[][] isWhitFree, boolean[][] isBlackFree) {
        int deltaRow = Math.abs(x - getRow())  , deltaCol = Math.abs(y - getCol()) ;
        /*System.out.println("x is " + x + " getrow is " + getRow());
        System.out.println("y is " + y + " getcol is " + getCol());
        System.out.println("delta is " + deltaRow + " and " +  deltaCol);*/
        if ( deltaRow == deltaCol || Math.abs(deltaRow-deltaCol) ==1)
        {
            if (x > getRow() && y > getCol()) {
                System.out.println("First");
                for (int i = getRow() + 1; i <= x; i++) {
                    for (int j = getCol() + 1; j <= y; j++) {
                        int deltaNewRaw = Math.abs(i - getRow()) , deltaNewCol = Math.abs(j - getCol());
                        if (deltaNewRaw == deltaNewCol) {
                            if ( !isWhitFree[i][j]  ) {
                                return false;
                            }
                        }
                    }
                }
            } else if (x < getRow() && y < getCol()) {
                System.out.println("second");
                for (int i = x; i < getRow() ; i++) {
                    for (int j = y; j < getCol() ; j++) {
                        int deltaNewRaw = Math.abs(i - getRow()) , deltaNewCol = Math.abs(j - getCol());
                        if (deltaNewRaw == deltaNewCol) {
                            if (!isWhitFree[i][j]) {
                                return false;
                            }
                        }
                    }
                }
            } else  if (x > getRow() && y < getCol()){
                System.out.println("third");

                for (int i = getRow() +1; i <= x; i++) {
                    for (int j = y; j < getCol() ; j++) {
                        int deltaNewRaw = Math.abs(i - getRow()) , deltaNewCol = Math.abs(j - getCol());
                        if (deltaNewRaw == deltaNewCol) {
                            if (!isWhitFree[i][j]) {
                                return false;
                            }
                        }

                    }
                }
            } else if (x < getRow() && y > getCol()){
                System.out.println("forth");
                for (int i = x ; i < getRow() ; i++) {
                    for (int j = getCol() + 1; j <= y; j++) {
                        int deltaNewRaw = Math.abs(i - getRow()) , deltaNewCol = Math.abs(j - getCol());
                        if (deltaNewRaw == deltaNewCol) {
                            if (!isWhitFree[i][j]) {
                                System.out.println("cant");
                                return false;
                            }
                        }

                    }
                }
            }

            return true;
        }

        return false;
    }
}