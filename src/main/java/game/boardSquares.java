package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class boardSquares extends JPanel implements ActionListener{

    private boolean movement = false , rebuild = false;
    private final boolean[] boolWhitePieces = new  boolean[16];
    private final boolean[] boolBlackPieces = new boolean[16]; //Includes All Pieces in each team (selected or not)
    private final boolean[][] isWhitFree = new boolean[8][8];
    private final boolean[][] isBlackFree = new boolean[8][8]; // Is This target square empty for ... Team ?
    private int whiteTurn = 1;  // 1 => Yes it is
    OneSide whiteSide = new OneSide("white");
    OneSide blackSide = new OneSide("black");

    Timer t = new Timer(0,this);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++) {
                isWhitFree[i][j] = true;
                isBlackFree[i][j] = true;
                //All squares are empty until i move any piece into it
            }
        }

        setIsWhitFreeValue(blackSide); // Make any square has a piece not Free
        setIsWhitFreeValue(whiteSide);

        //Click Action
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX()/100;
                int y = e.getY()/100;

                if (whiteTurn == 1){
                    setMovementValue(x, y, whiteSide);
                } else {
                    setMovementValue(x, y, blackSide);
                }
                rebuild = true;
            }
        });


        if(movement){
            //System.out.println("moveeeeeeemenet");
            moving();
            movement = false;

        }

        t.start();

        Draw(g);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void moving(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX()/100;
                int y = e.getY()/100;

                if (whiteTurn == 1) {
                    moveSide(x, y, whiteSide);
                }
                else  {
                    moveSide(x, y, blackSide);
                }
            }
        });

    }

    private void Draw(Graphics g){ // Drawing Pieces & Board

        g.drawImage(new ImageIcon("ChessBoard.jpg").getImage(),0,0,this);

        for(int i = 0 ; i < 2 ; i++) {
            g.drawImage(new ImageIcon("white_rook.png").getImage(),whiteSide.rooks[i].getRow()*100,whiteSide.rooks[i].getCol()*100,this);
            g.drawImage(new ImageIcon("white_bishop.png").getImage(),whiteSide.bishops[i].getRow()*100,whiteSide.bishops[i].getCol()*100,this);
            g.drawImage(new ImageIcon("white_knight.png").getImage(),whiteSide.knights[i].getRow()*100,whiteSide.knights[i].getCol()*100,this);

        }
        g.drawImage(new ImageIcon("white_queen.png").getImage(),whiteSide.queen.getRow()*100,whiteSide.queen.getCol()*100,this);
        g.drawImage(new ImageIcon("white_king.png").getImage(),whiteSide.king.getRow()*100,whiteSide.king.getCol()*100,this);

        for (int i = 0 ; i < 8 ; i++) {
            g.drawImage(new ImageIcon("white_pawn.png").getImage(), whiteSide.pawns[i].getRow() * 100, whiteSide.pawns[i].getCol() * 100, this);
        }

        for(int i = 0 ; i < 2 ; i++) {
            g.drawImage(new ImageIcon("black_rook.png").getImage(), blackSide.rooks[i].getRow() * 100, blackSide.rooks[i].getCol() * 100, this);
            g.drawImage(new ImageIcon("black_bishop.png").getImage(),blackSide.bishops[i].getRow()*100,blackSide.bishops[i].getCol()*100,this);
            g.drawImage(new ImageIcon("black_knight.png").getImage(),blackSide.knights[i].getRow()*100,blackSide.knights[i].getCol()*100,this);


        }

        for(int i = 0 ; i < 8 ; i++){
            g.drawImage(new ImageIcon("black_pawn.png").getImage(),blackSide.pawns[i].getRow()*100,blackSide.pawns[i].getCol()*100,this);
        }
        g.drawImage(new ImageIcon("black_queen.png").getImage(),blackSide.queen.getRow()*100,blackSide.queen.getCol()*100,this);
        g.drawImage(new ImageIcon("black_king.png").getImage(),blackSide.king.getRow()*100,blackSide.king.getCol()*100,this);


    }

    private void setIsWhitFreeValue(OneSide oneSide){
        if (oneSide.king.getWhite() ) {
            isWhitFree[oneSide.rooks[0].getRow()][oneSide.rooks[0].getCol()] = false;
            isWhitFree[oneSide.rooks[1].getRow()][oneSide.rooks[1].getCol()] = false;
            isWhitFree[oneSide.bishops[0].getRow()][oneSide.bishops[0].getCol()] = false;
            isWhitFree[oneSide.bishops[1].getRow()][oneSide.bishops[1].getCol()] = false;
            isWhitFree[oneSide.knights[0].getRow()][oneSide.knights[0].getCol()] = false;
            isWhitFree[oneSide.bishops[1].getRow()][oneSide.bishops[1].getCol()] = false;
            isWhitFree[oneSide.queen.getRow()][oneSide.queen.getCol()] = false;
            isWhitFree[oneSide.king.getRow()][oneSide.king.getCol()] = false;

            for (int i = 0; i < 8; i++) {
                isWhitFree[oneSide.pawns[i].getRow()][oneSide.pawns[i].getCol()] = false;
            }
        }
        else {
            isBlackFree[oneSide.rooks[0].getRow()][oneSide.rooks[0].getCol()] = false;
            isBlackFree[oneSide.rooks[1].getRow()][oneSide.rooks[1].getCol()] = false;
            isBlackFree[oneSide.bishops[0].getRow()][oneSide.bishops[0].getCol()] = false;
            isBlackFree[oneSide.bishops[1].getRow()][oneSide.bishops[1].getCol()] = false;
            isBlackFree[oneSide.knights[0].getRow()][oneSide.knights[0].getCol()] = false;
            isBlackFree[oneSide.bishops[1].getRow()][oneSide.bishops[1].getCol()] = false;
            isBlackFree[oneSide.queen.getRow()][oneSide.queen.getCol()] = false;
            isBlackFree[oneSide.king.getRow()][oneSide.king.getCol()] = false;

            for (int i = 0; i < 8; i++) {
                isBlackFree[oneSide.pawns[i].getRow()][oneSide.pawns[i].getCol()] = false;
            }


        }
    }

    private void setMovementValue(int x , int y , OneSide oneSide ) { // which peace is selected
        if (x == oneSide.rooks[0].getRow() && y == oneSide.rooks[0].getCol()) {
            if(oneSide.rooks[0].getWhite()) {       //To know which team this piece belongs to (is it white team ?)
                boolWhitePieces[0] = true;      //whitePieces[0] is rook , whitePieces[1] is Knight , ...

            } else { //(No it's Black Team)
                boolBlackPieces[0] = true;
            }

            movement =  true;
        }
        else if (x == oneSide.rooks[1].getRow() && y == oneSide.rooks[1].getCol()) { //(Or 2nd Rook ?)
            if(oneSide.rooks[1].getWhite()) {
                boolWhitePieces[7] = true;
            }
            else {
                boolBlackPieces[7] = true;
                System.out.println("rook 1 black is selected");
            }
            movement = true;

        } else if (x == oneSide.knights[0].getRow() && y == oneSide.knights[0].getCol()) {
            if(oneSide.knights[0].getWhite()) {
                boolWhitePieces[1] = true;
                System.out.println("knight 0 white is selected");
            }
            else {
                boolBlackPieces[1] = true;
                System.out.println("knight 0 black is selected");
            }
            movement = true;

        } else if (x == oneSide.knights[1].getRow() && y == oneSide.knights[1].getCol()) {
            if(oneSide.knights[1].getWhite()) {
                boolWhitePieces[6] = true;
                System.out.println("knight 1 white is selected");
            }
            else {
                boolBlackPieces[6] = true;
                System.out.println("knight 1 black is selected");
            }
            movement = true;

        } else if (x == oneSide.bishops[0].getRow() && y == oneSide.bishops[0].getCol()) {
            if(oneSide.bishops[0].getWhite()) {
                boolWhitePieces[2] = true;
                System.out.println("bishop 0 white is selected");
            }
            else {
                boolBlackPieces[2] = true;
                System.out.println("bishop 0 black is selected");
            }
            movement = true;

        } else if (x == oneSide.bishops[1].getRow() && y == oneSide.bishops[1].getCol()) {
            if(oneSide.bishops[1].getWhite()) {
                boolWhitePieces[5] = true;
                System.out.println("bishop 1 white is selected");
            }
            else {
                boolBlackPieces[5] = true;
                System.out.println("bishop 1 black is selected");
            }
            movement = true;

        } else if (x == oneSide.queen.getRow() && y == oneSide.queen.getCol()) {
            if(oneSide.queen.getWhite()) {
                boolWhitePieces[3] = true;
                System.out.println("queen white is selected");
            }
            else {
                boolBlackPieces[3] = true;
                System.out.println("queen black is selected");
            }
            movement = true;
        } else if (x == oneSide.king.getRow() && y == oneSide.king.getCol()) {
            if(oneSide.king.getWhite()) {
                boolWhitePieces[4] = true;
                System.out.println("king white is selected");
            }
            else {
                boolBlackPieces[4] = true;
                System.out.println("king black is selected");
            }
            movement =  true;
        }else {
            for (int i = 0; i < 8; i++) {
                if (x == oneSide.pawns[i].getRow() && y == oneSide.pawns[i].getCol()) {
                    if(oneSide.pawns[i].getWhite()) {
                        System.out.println("iam white");
                        boolWhitePieces[i+8] = true;
                        System.out.println("pawn " + ++i + " white is selected");
                    }
                    else {
                        boolBlackPieces[i+8] = true;
                        System.out.println("pawn " + ++i +" black is selected");
                    }
                    movement =  true;
                }
            }
        }


    }

    private void moveSide(int x , int y , OneSide oneSide ){

        if((boolWhitePieces[0] || boolBlackPieces[0])  && oneSide.rooks[0].isValid(x ,y , isWhitFree,isBlackFree)){
            if (x == oneSide.rooks[0].getRow() && y == oneSide.rooks[0].getCol())
                return;

            isWhitFree[oneSide.rooks[0].getRow()][oneSide.rooks[0].getCol()] = true;

            oneSide.rooks[0].setRow(x);
            oneSide.rooks[0].setCol(y);
            oneSide.rooks[0].firstMove = true;

            isWhitFree[oneSide.rooks[0].getRow()][oneSide.rooks[0].getCol()] = false;
            boolBlackPieces[0] = false;
            boolWhitePieces[0] = false;

            changeTurn();

        }else if((boolWhitePieces[7] || boolBlackPieces[7])  && oneSide.rooks[1].isValid(x ,y , isWhitFree,isBlackFree)){
            if (x == oneSide.rooks[1].getRow() && y == oneSide.rooks[1].getCol())
                return;

            isWhitFree[oneSide.rooks[1].getRow()][oneSide.rooks[1].getCol()] = true;

            oneSide.rooks[1].setRow(x);
            oneSide.rooks[1].setCol(y);
            oneSide.rooks[1].firstMove = true;

            isWhitFree[oneSide.rooks[1].getRow()][oneSide.rooks[1].getCol()] = false;

            boolWhitePieces[7] = false;
            boolBlackPieces[7] = false;

            changeTurn();
        }else if((boolWhitePieces[1] || boolBlackPieces[1]) && oneSide.knights[0].isValid(x ,y , isWhitFree,isBlackFree)){
            isWhitFree[oneSide.knights[0].getRow()][oneSide.knights[0].getCol()] = true;

            oneSide.knights[0].setRow(x);
            oneSide.knights[0].setCol(y);

            isWhitFree[oneSide.knights[0].getRow()][oneSide.knights[0].getCol()] = false;

            boolBlackPieces[1] = false;
            boolWhitePieces[1] = false;

            System.out.println("move");

            changeTurn();
        }else if((boolWhitePieces[6] || boolBlackPieces[6])  && oneSide.knights[1].isValid(x ,y , isWhitFree,isBlackFree)){
            isWhitFree[oneSide.knights[1].getRow()][oneSide.knights[1].getCol()] = true;

            oneSide.knights[1].setRow(x);
            oneSide.knights[1].setCol(y);

            isWhitFree[oneSide.knights[1].getRow()][oneSide.knights[1].getCol()] = false;
            boolBlackPieces[6] = false;
            boolWhitePieces[6] = false;

            changeTurn();
        }else if((boolWhitePieces[2] || boolBlackPieces[2])  && oneSide.bishops[0].isValid(x ,y , isWhitFree,isBlackFree)){
            if (x == oneSide.bishops[0].getRow() && y == oneSide.bishops[0].getCol())
                return;

            isWhitFree[oneSide.bishops[0].getRow()][oneSide.bishops[0].getCol()] = true;

            oneSide.bishops[0].setRow(x);
            oneSide.bishops[0].setCol(y);

            isWhitFree[oneSide.bishops[0].getRow()][oneSide.bishops[0].getCol()] = false;
            boolBlackPieces[2] = false;
            boolWhitePieces[2] = false;

            changeTurn();
        }
        else if((boolWhitePieces[5] || boolBlackPieces[5])  && oneSide.bishops[1].isValid(x ,y , isWhitFree,isBlackFree)){
            if (x == oneSide.bishops[1].getRow() && y == oneSide.bishops[1].getCol())
                return;

            isWhitFree[oneSide.bishops[1].getRow()][oneSide.bishops[1].getCol()] = true;

            oneSide.bishops[1].setRow(x);
            oneSide.bishops[1].setCol(y);

            isWhitFree[oneSide.bishops[1].getRow()][oneSide.bishops[1].getCol()] = false;
            boolBlackPieces[5] = false;
            boolWhitePieces[5] = false;

            changeTurn();
        }
        else if((boolWhitePieces[3] || boolBlackPieces[3])  && oneSide.queen.isValid(x ,y , isWhitFree,isBlackFree)){
            if (x == oneSide.queen.getRow() && y == oneSide.queen.getCol())
                return;


            
            isWhitFree[oneSide.queen.getRow()][oneSide.queen.getCol()] = true;

            System.out.println("moveeeeee queen");
            oneSide.queen.setRow(x);
            oneSide.queen.setCol(y);

            isWhitFree[oneSide.queen.getRow()][oneSide.queen.getCol()] = false;
            boolBlackPieces[3] = false;
            boolWhitePieces[3] = false;

            changeTurn();
        }
        else if((boolWhitePieces[4] || boolBlackPieces[4])  && oneSide.king.isValid(x ,y , isWhitFree ,isBlackFree)){
            isWhitFree[oneSide.king.getRow()][oneSide.king.getCol()] = false;

            if (oneSide.king.doCastling == true){

                if (oneSide.king.castlingRook1 == true){
                    if (oneSide.rooks[1].firstMove == false){
                        if ( (isWhitFree[oneSide.king.getRow()+1][oneSide.king.getCol()] == true &&
                                isWhitFree[oneSide.king.getRow()+2][oneSide.king.getCol()] == true && oneSide.king.getWhite())
                            || (isBlackFree[oneSide.king.getRow()+1][oneSide.king.getCol()] == true &&
                                isBlackFree[oneSide.king.getRow()+2][oneSide.king.getCol()] == true && !oneSide.king.getWhite())){
                            // move the king
                            oneSide.king.setRow(oneSide.king.getRow()+2);  // row value do not change
                            oneSide.king.setCol(oneSide.king.getCol());  // move two cells towards the rook
                            oneSide.king.firstMove = true;
                            oneSide.king.castled = true;
                            isWhitFree[oneSide.king.getRow()][oneSide.king.getCol()] = true;
                            boolBlackPieces[4] = false;
                            boolWhitePieces[4] = false;
                            // move the right rook
                            oneSide.rooks[1].setRow(oneSide.rooks[1].getRow()-2); // row value do not change
                            oneSide.rooks[1].setCol(oneSide.rooks[1].getCol());
                            oneSide.rooks[1].firstMove = true;
                            isWhitFree[oneSide.rooks[1].getRow()][oneSide.rooks[1].getCol()] = true;
                            boolBlackPieces[1] = false;
                            boolWhitePieces[1] = false;
                            changeTurn();

                        }
                    }
                    else System.out.println("invalid castling");
                }

                else {
                    if (oneSide.rooks[0].firstMove == false){
                        if ( (isWhitFree[oneSide.king.getRow()-1][oneSide.king.getCol()] == true &&
                                isWhitFree[oneSide.king.getRow()-2][oneSide.king.getCol()] == true &&
                                isWhitFree[oneSide.king.getRow()-3][oneSide.king.getCol()] == true &&
                                oneSide.king.getWhite() ) ||
                                (isBlackFree[oneSide.king.getRow()-1][oneSide.king.getCol()] == true &&
                                        isBlackFree[oneSide.king.getRow()-2][oneSide.king.getCol()] == true &&
                                        isBlackFree[oneSide.king.getRow()-3][oneSide.king.getCol()] == true &&
                                        !oneSide.king.getWhite() )    ){
                            // move the king
                            oneSide.king.setRow(oneSide.king.getRow()-2);  // row value do not change
                            oneSide.king.setCol(oneSide.king.getCol());  // move two cells towards the rook
                            oneSide.king.firstMove = true;
                            isWhitFree[oneSide.king.getRow()][oneSide.king.getCol()] = true;
                            boolBlackPieces[4] = false;
                            boolWhitePieces[4] = false;
                            oneSide.king.castled = true;
                            // move the left rook
                            oneSide.rooks[0].setRow(oneSide.rooks[0].getRow()+3);
                            oneSide.rooks[0].setCol(oneSide.rooks[0].getCol());
                            oneSide.rooks[0].firstMove = true;
                            isWhitFree[oneSide.rooks[0].getRow()][oneSide.rooks[0].getCol()] = true;
                            boolBlackPieces[0] = false;
                            boolWhitePieces[0] = false;

                            changeTurn();
                        }
                    }
                    else System.out.println("invalid castling");
                }
            }

            else {
                oneSide.king.setRow(x);
                oneSide.king.setCol(y);
                oneSide.king.firstMove = true;

                isWhitFree[oneSide.king.getRow()][oneSide.king.getCol()] = true;
                boolBlackPieces[4] = false;
                boolWhitePieces[4] = false;
                changeTurn();
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                System.out.println("loop");
                if (boolWhitePieces[i+8] )
                    System.out.println("bool is true");
                if ((boolWhitePieces[i+8] || boolBlackPieces[i+8])  && oneSide.pawns[i].isValid(x ,y , isWhitFree,isBlackFree)) {
                    System.out.println("here");
                    isWhitFree[oneSide.knights[1].getRow()][oneSide.knights[1].getCol()] = true;

                    oneSide.pawns[i].setRow(x);
                    oneSide.pawns[i].setCol(y);

                    isWhitFree[oneSide.knights[1].getRow()][oneSide.knights[1].getCol()] = false;
                    boolBlackPieces[i+8] = false;

                    changeTurn();
                }
            }
            for(int i = 0 ; i < 16 ; i++){
                boolBlackPieces[i] = false;
                boolWhitePieces[i] = false;
            }
        }

    }
    void changeTurn(){
        if (whiteTurn == 1){
            whiteTurn = 0;
        }
        else
            whiteTurn = 1 ;
    }


    boolean isChakeMate(OneSide oneSide){
        if (oneSide.king.getWhite()){
            //check if where knight can kill the king
            if(blackSide.knights[0].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    blackSide.knights[1].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ) {

                return true;
            }

            else if(blackSide.bishops[0].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    blackSide.bishops[1].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    blackSide.rooks[0].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    blackSide.rooks[1].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    blackSide.queen.isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ){

                return true;
            }

            for (int i = 0 ; i < 8 ; i++){
                if(blackSide.pawns[i].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ) {
                    return true;
                }
            }


        }

        else {
            if(whiteSide.knights[0].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    whiteSide.knights[1].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ){
                return true;

            }


            else if(whiteSide.bishops[0].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    whiteSide.bishops[1].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    whiteSide.rooks[0].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    whiteSide.rooks[1].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ||
                    whiteSide.queen.isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ){
                return true;
            }

            for (int i = 0 ; i < 8 ; i++){
                if(whiteSide.pawns[i].isValid(oneSide.king.getRow() , oneSide.king.getCol() , isWhitFree , isBlackFree) ) {
                    return true;
                }
            }

        }
        return false;
    }

}