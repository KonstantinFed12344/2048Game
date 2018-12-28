/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

/**
 * \par \par
 *
 * @author Konstantin
 */
public class Coordinate {

    private int column;
    private int row;

    /**
     * Constructor for Coordinate class
     *
     * @param column
     * @param row
     * @throws IndexOutOfBoundsException
     */
    public Coordinate(int column, int row) throws IndexOutOfBoundsException {
        if ((column < 0) || (column > 3)) {
            throw new IndexOutOfBoundsException("column must be between 0 and 3,inclusive");
        }
        if ((row < 0) || (row > 3)) {
            throw new IndexOutOfBoundsException("row must be between 0 and 3,inclusive");
        }
        this.column = column;
        this.row = row;

    }

    public Coordinate(char column, char row) throws IndexOutOfBoundsException {
        if ((column < 'a') || (column > 'd')) {
            throw new IndexOutOfBoundsException("column must be between a and d,inclusive");
        }
        if ((row < '1') || (row > '4')) {
            throw new IndexOutOfBoundsException("row must be between 1 and 4,inclusive");
        }
        this.column = (int) (column - 97);
        this.row = (int) (row - 49);

    }

    public Coordinate(String coordinate) throws IndexOutOfBoundsException {
        if (coordinate.length() != 2) {
            throw new IllegalArgumentException("Coordinate is a 2-character string");
        }
        char column = coordinate.charAt(0);
        char row = coordinate.charAt(1);
        if ((column < 'a') || (column > 'd')) {
            throw new IndexOutOfBoundsException("x must be between a and d, inclusive");
        }
        if ((row < '1') || (row > '4')) {
            throw new IndexOutOfBoundsException("y must be between 1 and 4, inclusive");
        }
        this.column = (int) (column - 97);
        this.row = (int) (row - 49);

    }

    public char getColumn() {
        return (char) (this.column + 97);
    }

    public int getColumnNumber() {
        return this.column;
    }

    public char getRow() {
        return (char) (this.row + 49);
    }

    public int getRowNumber() {
        return this.row;
    }

    public String name() {
        return (Character.toString((char) (this.column + 97)) + Character.toString((char) (this.row + 49)));
    }

    public String toString() {
        return "(" + (char) (this.column + 48) + "," + (char) (this.row + 48) + ")";
    }

}
