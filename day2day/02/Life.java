import java.io.*;
import java.util.*;
/*
  2D array 
  set up 
  change values in it
  a way of applying the GOL rules 
 */

public class Life{
	// CONSTANTS
	static final char ALIVE = 'X';
	static final char DEAD = ' ';
	static final char ROWS = 25;
	static final char COLS = 25;
	
    /*
      create a new 2D array, fill it with ' ' 
      representing that the entire board is empty.
     */
    public static char[][] createNewBoard(int rows, int cols){
		char[][] board = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board[r][c] = DEAD;
			}
		}
		return board;
    }

    // Just print the board
    public static void printBoard(char[][] board){
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				System.out.printf("%c",board[r][c]);
			}
			System.out.println();
		}
		System.out.println("\n\n------------------\n\n");
    }

    /*
      set the cell (r,c) to value
    */
    public static void setCell(char[][] board, int r, int c, char val){
		if (r>=0 && r<board.length && c>=0 && c<board[r].length){
			board[r][c] = val;
		}
    }

    /* 
       Count and return the number of living neigbords around board[r][c]
       approach 1 - lots of if statements
       approach 2 - you can loop over the grid from board[r-1][c-1]
                    to board[r+1][c+1]
    */
    public static int countNeighbours(char[][] board, int row, int col){
	
		// Valid row start & stop (edge of board)
		int rStart = row - 1;
		if (row-1 < 0) rStart = row;
		int rStop = row + 1;
		if (row+1 >= board.length) rStop = row;
		
		// Valid column start & stop (edge of board)
		int cStart = col - 1;
		if (col-1 < 0) cStart = col;
		int cStop = col + 1;
		if (col+1 >= board.length) cStop = col;
			
		// Count neighbors
		int count = 0;
		for (int r = rStart; r <= rStop; r++) {
			for (int c = cStart; c <= cStop; c++) {
				if (board[r][c] == ALIVE)
					count++;
			}
		}
		// Counted the actual cell?
		if ( board[row][col]==ALIVE ) 
			count--;
		
		return count;
    }
    
    /*
      given a board and a cell, determine, based on the rules for 
      Conway's GOL if the cell is alive ('X') or dead (' ') in the 
      next generation.
      
     */
    public static char getNextGenCell(char[][] board,int r, int c){
	// calculate the number of living neighbors around board[r][c]

	// determine if board[r][c] is living or dead
	//    if living and 2 3 neighbors then remain alive
	//    if dead and 3 neighbors then become alive
		
		int neighbors = countNeighbours(board, r, c);
		if ( (board[r][c] == ALIVE) && ((neighbors == 2)||(neighbors == 3)) )
			return ALIVE;
		else if ((board[r][c] == DEAD) && (neighbors == 3))
			return ALIVE;
		else
			return DEAD;
    }
	
    /*
      scan the board to generate a NEW board with the
      next generation
    */
    public static char[][] generateNextBoard(char[][] board){
		char newBoard[][] = new char[ROWS][COLS];
		// fill the new board
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				newBoard[r][c] = getNextGenCell(board,r,c);
			}
		}
		return newBoard;
    }
    
    public static void main(String[] args) {
		char[][] board;
		char[][] nextBoard;
		board = createNewBoard(ROWS,COLS);
		
		// put a few live cells on the board
		// setCell(board, 10,10, ALIVE);
		// setCell(board, 10,11, ALIVE);
		setCell(board, 11,10, ALIVE);
		setCell(board, 11,11, ALIVE);
		
		printBoard(board);
		
		nextBoard = generateNextBoard(board);
		printBoard(nextBoard);
    }
}