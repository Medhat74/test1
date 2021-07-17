package game;

public abstract class Piece {
    private int row , col ;
    private final boolean white;
    private boolean move;


    public boolean getWhite() {
        return white;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    Piece(int row , int col , boolean white){
        this.row = row;
        this.col = col;
        this.white = white;
    }

    protected abstract boolean isValid(int x , int y , boolean[][] isWhitFree, boolean[][] isBlackFree);

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}
