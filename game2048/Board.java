/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Konstantin
 * @version 1.0
 */
public class Board {

    private Square[][] board;
    private HashMap<Square, Square> positionSwap;

    /**
     * Constructor for 2048 Board Produces a 4x4 2048 board with two randomly
     * placed 2's using the @see randomSpawn() method
     */
    public Board() {

        board = new Square[4][4];

        for (int c = 0; c < 4; c++) {
            for (int r = 0; r < 4; r++) {
                board[c][r] = new Square(new Coordinate(c, r));
            }
        }
        positionSwap = new HashMap<Square, Square>();
        this.randomSpawn();

    }

    /**
     * Randomly spawns two 2's, or less if there is no room, in a 0 space for a
     * 4x4 2048 board
     *
     */
    public void randomSpawn() {

        int numSpawn = 0;
        Random random = new Random();
        int horizon;
        int vert;

        while (numSpawn != 2 && numSpawn < this.freeSpaces()) {
            horizon = random.nextInt(4);
            vert = random.nextInt(4);

            if (board[vert][horizon].getValue() == 0) {
                board[vert][horizon].setValue(2);
                numSpawn++;
            }
        }

    }

    public void moveUp() {
        boolean legal = true;
        boolean moved = false;
        int bound = -1;
        this.positionSwap.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (board[i][j].getValue() > 0) {
                    for (int k = 0; k <= j; k++) {
                        if (((board[i][j].getValue() == board[i][k].getValue() && k != j) || board[i][k].getValue() == 0) && k != bound) {
                            for (int t = k; t <= j; t++) {
                                if (board[i][j].getValue() != board[i][t].getValue() && board[i][t].getValue() != 0 || bound == t) {
                                    legal = false;
                                }
                            }
                            if (legal) {
                                if (board[i][j].getValue() == board[i][k].getValue()) {
                                    bound = k;
                                }
                                Square oldPosition = new Square(new Coordinate(i, j));
                                oldPosition.setValue(board[i][j].getValue());
                                Square newPosition = new Square(new Coordinate(i, k));
                                oldPosition.setValue(board[i][k].getValue() * 2);
                                this.positionSwap.put(oldPosition, newPosition);
                                this.move(board[i][j], board[i][k]);
                                moved = true;
                                break;
                            }
                            legal = true;
                        }
                    }
                }
            }
            bound = -1;
        }
        if (moved) {
            this.randomSpawn();
        }
    }

    public void moveDown() {
        boolean legal = true;
        boolean moved = false;
        int bound = -1;
        this.positionSwap.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (board[i][j].getValue() > 0) {
                    for (int k = 3; k >= j; k--) {
                        if (((board[i][j].getValue() == board[i][k].getValue() && k != j) || board[i][k].getValue() == 0) && k != bound) {
                            for (int t = k; t >= j; t--) {
                                if (board[i][j].getValue() != board[i][t].getValue() && board[i][t].getValue() != 0 || bound == t) {
                                    legal = false;
                                }
                            }
                            if (legal) {
                                if (board[i][j].getValue() == board[i][k].getValue()) {
                                    bound = k;
                                }
                                Square oldPosition = new Square(new Coordinate(i, j));
                                oldPosition.setValue(board[i][j].getValue());
                                Square newPosition = new Square(new Coordinate(i, k));
                                oldPosition.setValue(board[i][k].getValue() * 2);
                                this.positionSwap.put(oldPosition, newPosition);
                                this.move(board[i][j], board[i][k]);
                                moved = true;
                                break;
                            }
                            legal = true;
                        }
                    }
                }
            }
            bound = -1;
        }
        if (moved) {
            this.randomSpawn();
        }
    }

    public void moveRight() {
        boolean legal = true;
        boolean moved = false;
        int bound = -1;
        this.positionSwap.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (board[j][i].getValue() > 0) {
                    for (int k = 3; k >= j; k--) {
                        if (((board[j][i].getValue() == board[k][i].getValue() && k != j) || board[k][i].getValue() == 0) && k != bound) {
                            for (int t = k; t >= j; t--) {
                                if (board[j][i].getValue() != board[t][i].getValue() && board[t][i].getValue() != 0 || bound == t) {
                                    legal = false;
                                }
                            }
                            if (legal) {
                                if (board[j][i].getValue() == board[k][i].getValue()) {
                                    bound = k;
                                }
                                Square oldPosition = new Square(new Coordinate(j, i));
                                oldPosition.setValue(board[j][i].getValue());
                                Square newPosition = new Square(new Coordinate(k, i));
                                oldPosition.setValue(board[k][i].getValue() * 2);
                                this.positionSwap.put(oldPosition, newPosition);
                                this.move(board[j][i], board[k][i]);
                                moved = true;
                                break;
                            }
                            legal = true;
                        }
                    }
                }
            }
            bound = -1;
        }
        if (moved) {
            this.randomSpawn();
        }
    }

    public void moveLeft() {
        boolean legal = true;
        boolean moved = false;
        int bound = -1;
        this.positionSwap.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 3; j++) {
                if (board[j][i].getValue() > 0) {
                    for (int k = 0; k <= j; k++) {
                        if (((board[j][i].getValue() == board[k][i].getValue() && k != j) || board[k][i].getValue() == 0) && k != bound) {
                            for (int t = k; t <= j; t++) {
                                if (board[j][i].getValue() != board[t][i].getValue() && board[t][i].getValue() != 0 || bound == t) {
                                    legal = false;
                                }
                            }
                            if (legal) {
                                if (board[j][i].getValue() == board[k][i].getValue()) {
                                    bound = k;
                                }
                                Square oldPosition = new Square(new Coordinate(j, i));
                                oldPosition.setValue(board[j][i].getValue());
                                Square newPosition = new Square(new Coordinate(k, i));
                                oldPosition.setValue(board[k][i].getValue() * 2);
                                this.positionSwap.put(oldPosition, newPosition);
                                this.move(board[j][i], board[k][i]);
                                moved = true;
                                break;
                            }
                            legal = true;

                        }
                    }
                }
            }
            bound = -1;
        }
        if (moved) {
            this.randomSpawn();
        }
    }

    public void move(Square source, Square dest) {

        dest.setValue(source.getValue() + dest.getValue());
        source.setValue(0);

    }

    public Square getSquare(int i, int j) {
        return board[i][j];
    }

    public int freeSpaces() {
        int freeSpace = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].getValue() == 0) {
                    freeSpace++;
                }
            }
        }

        return freeSpace;
    }

    public boolean isLegal() {
        return true;
    }
    
    public HashMap<Square,Square> getPositionSwap(){
        return this.positionSwap;
    }

    public void toBoard() {
        String strBoard;
        strBoard = "";
        for (int i = 0; 4 > i; i++) {
            for (int k = 0; k < 4; k++) {
                strBoard = strBoard + board[k][i].toString() + "|";
            }
            strBoard += "\n";
        }
        System.out.println(strBoard);
    }
}
