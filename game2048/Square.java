/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

/**
 *
 * @author Konstantin
 */
public class Square {

    private Coordinate coordinate;
    private int value;

    public Square(Coordinate c) {

        this.coordinate = c;
        this.value = 0;

    }

    public char getColumn() {
        return this.coordinate.getColumn();
    }

    public char getRow() {
        return this.coordinate.getRow();
    }

    public int getColumnNumber() {
        return this.coordinate.getColumnNumber();
    }

    public int getRowNumber() {
        return this.coordinate.getRowNumber();
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isOccupied() {
        if (this.value == 0) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return "" + this.value;

    }
}
