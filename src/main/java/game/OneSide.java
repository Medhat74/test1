package game;

public class OneSide {
    protected Rook []rooks = new Rook[2];
    protected Bishop []bishops = new Bishop[2];
    protected Knight []knights = new Knight[2];
    protected Pawn []pawns = new Pawn[8];
    protected Queen queen;
    protected King king ;

    OneSide(String color){
        if (color.equals("white")) {
            locations(7 , true);
        } else {
            locations(0 , false);
        }
    }

    private void locations(int location , boolean white){
        rooks[0] = new Rook(0, location , white);
        rooks[1] = new Rook(7, location , white);
        bishops[0] = new Bishop(2, location , white);
        bishops[1] = new Bishop(5, location , white);
        knights[0] = new Knight(1, location , white);
        knights[1] = new Knight(6, location , white);
        queen = new Queen(3, location , white);
        king = new King(4, location , white);
        if (location == 7) {
            for (int i = 0; i < 8; i++) {
                pawns[i] = new Pawn(i, location-1 , white);
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                pawns[i] = new Pawn(i, location+1 , white);
            }
        }
    }

    public void howCanMove(boolean[] iscanMove) {
        for(int i = 0 ; i < 16 ; i++ ){

        }
    }

}