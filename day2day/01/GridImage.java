import java.io.*;
import java.util.*;

 public class GridImage {

  public static void main(String[] args) {

    int rows = 20;
    int cols = 20;

    int[][] grid = new int[rows][cols];
	
	for (int r=0; r < grid.length; r++) {
      for (int c=0; c < grid[r].length; c++) {
		  grid[r][c] = 111;
      }//end c for
    }//end r for

    print2d(grid);
    System.out.println("******************************");
	colPop(grid,3,0);
	print2d(grid);
    System.out.println("******************************");
	rowPop(grid,9,0);
	print2d(grid);
    System.out.println("******************************");
	invert(grid);
	print2d(grid);
    System.out.println("***********up & left***********");
	diagonal(grid,10,10,0,111);
	print2d(grid);
    System.out.println("************up & right*********");
	diagonal(grid,10,10,1,111);
	print2d(grid);
	System.out.println("***********down & left*********");
	diagonal(grid,10,10,2,111);
	print2d(grid);
	System.out.println("**********down & right*********");
	diagonal(grid,10,10,3,111);
	print2d(grid);
 }

  public static void print2d(int[][] d2) {
    for (int r=0; r < d2.length; r++) {
      for (int c=0; c < d2[r].length; c++) {
        System.out.printf("%03d ", d2[r][c]);
      }//end c for
      System.out.println();
    }//end r for
  }//end print2d

  public static void colPop(int[][] d2, int c, int value) {
	for (int r=0; r < d2.length; r++) {
        d2[r][c-1] = value;
    }//end r for
  }//end colPop

  public static void rowPop(int[][] d2, int r, int value) {  
    for (int c=0; c < d2[r].length; c++) {
      d2[r-1][c] = value;
    }//end c for
  }//end rowPop

  public static void invert(int[][] d2) {
	for (int r=0; r < d2.length; r++) {
      for (int c=0; c < d2[r].length; c++) {
        if ( d2[r][c] == 0 ) {
			d2[r][c] = 255;
		} else {
			d2[r][c] = 0;
		} // end if 
      }//end c for
    }//end r for
  }//end invert

  /*
    0: up + left
    1: up + right
    2: down + left
    3: down + right
   */
  public static void diagonal(int[][] d2, int row, int col, int direction, int value) {
	if (direction == 3){
		// down & right
		for (int r=row-1; r < d2.length; r++) {
		  for (int c=col-1; c < d2[r].length; c++) {
			if ( r == c ){
					d2[r][c] = value;	
			} //end if r == c
		  }//end c for
		}//end r for
	} else if (direction == 2) {
		// down & left
		for (int r=row-1; r < d2.length; r++){
		  for (int c=0; c < col; c++) {
			if ( r + c == d2.length-1 ) {
					d2[r][c] = value;	
			} // end if r + c
		  }//end c for
		}//end r for
	} else if (direction == 1) {
		// up & right
		for (int r=0; r < row; r++) {
		  for (int c=col-1; c < d2[r].length; c++) {
			if ( r + c == d2.length-1 ) {
					d2[r][c] = value;	
			} // end if r + c
		  }//end c for
		}//end r for
	} else { // direction == 0
		// up & left
		for (int r=row-1; r >=0; r--) {
		  for (int c=0; c < col; c++) {
			if ( r == c ){
					d2[r][c] = value;	
			} //end if r == c
		  }//end c for
		}//end r for
	} // end else
  }//end diagonal

}