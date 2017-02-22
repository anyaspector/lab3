/**
 * Squares of a maze. 
 * 
 * Feb 21, 2017
 * 
 * @author anyaspector
 *
 */

public class Square {

    private int row;
    private int col;
    private int type;
    private int resetType;

    public int getRow(){
	return this.row;
    }

    public int getCol(){
	return this.col;
    }
    
    public int getType(){
	return this.type;
    }

    //constructor
    public Square(int row, int col, int type) {
	this.row = row;
	this.col = col;
	this.type = type;
	this.resetType = type;
    }

    //switch to string
    public String toString() {
	switch (this.type) {
	case 0:
	    return "_";
	case 1:
	    return "#";
	case 2:
	    return "S";
	case 3:
	    return "E";
	default:
	    return null;
	}
    }
    
    //RESET
    public void reset(){
	this.type=this.resetType;
    }

}
