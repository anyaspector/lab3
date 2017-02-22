import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Maze Itself.
 * 
 * Feb 21, 2017
 * 
 * @author anyaspector
 *
 */
public class Maze {

    private Square[][] maze;
    private Square start;
    private Square finish;
    private int numRows=0;
    private int numCols=0;

    public Maze(){
    }

    boolean loadMaze(String fname){
	try{
	    //read the number of columns and rows in a maze
	    Scanner fileReader= new Scanner (new File(fname));
	    String firstLine= fileReader.nextLine();
	    Scanner firstLineScanner = new Scanner(firstLine);
	    this.numRows = Integer.parseInt(firstLineScanner.next());
	    this.numCols = Integer.parseInt(firstLineScanner.next());
	    firstLineScanner.close();

	    //make the maze!
	    this.maze = new Square[this.numRows][this.numCols];

	    //fill in the maze
	    for (int row = 0; row < this.numRows; row++) {
		String line = fileReader.nextLine();
		Scanner lineReader = new Scanner(line);

		for (int col = 0; col < this.numCols; col++) {
		    int type = Integer.parseInt(lineReader.next());
		    maze[row][col] = new Square(row, col, type);
		    switch (type) {
		    case 2:
			this.start = maze[row][col];
			break;
		    case 3:
			this.finish = maze[row][col];
			break;
		    default:
			////
		    }
		}
		lineReader.close();

	    }
	    fileReader.close();
	    return true;
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found!");
	    return false;
	}
    }

    public ArrayList<Square> getNeighbors(Square sq){
	ArrayList<Square> neighbors = new ArrayList<Square>(4);
	if (sq.getRow() - 1 >= 0)
	    neighbors.add(this.maze[sq.getRow() - 1][sq.getCol()]);//north
	if (sq.getCol() + 1 < this.numCols)
	    neighbors.add(this.maze[sq.getRow()][sq.getCol() + 1]);//east
	if (sq.getRow() + 1 < this.numRows)
	    neighbors.add(this.maze[sq.getRow() + 1][sq.getCol()]);//south
	if (sq.getCol() - 1 >= 0)
	    neighbors.add(this.maze[sq.getRow()][sq.getCol() - 1]);//west
	return neighbors;
    }

    public Square getStart() {
	return this.start;
    }

    public Square getFinish() {
	return this.finish;
    }

    public void reset(){
	for (int row = 0; row < this.numRows; row++) {
	    for (int col = 0; col < numCols; col++) {
		maze[row][col].reset();
	    }
	}

    }

    public String toString(){
	StringBuilder sb = new StringBuilder();
	for (int row=0; row<this.numRows; row++){
	    for (int col = 0; col < numCols; col++) {
		sb.append(maze[row][col].toString());
	    }
	    sb.append("\n");//?
	}
	
	
	String s = new String(sb);
	return s;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
