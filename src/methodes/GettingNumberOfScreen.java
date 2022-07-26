package methodes;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class GettingNumberOfScreen {
	private static int[][] board = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};;

	
    public static int[][] getBoard() throws MalformedURLException {

		ScreenRegion s = new DesktopScreenRegion();
       
		for (int image = 1; image <= 9; image++) {
			  System.out.println("Recherche de "+image);
			  File file = new File("C:/Users/AdrienBlanc/Desktop/Code/SUDOKU/.com/"+image+".jpeg");
			  //File file = new File("C:/Users/AdrienBlanc/Desktop/SUDOKU/.com/"+image+".jpeg");
		      Target imageTarget = new ImageTarget(file);
		      imageTarget.doFindAll(s);
		      imageTarget.setMinScore(0.9);
		      imageTarget.setOrdering(Target.Ordering.DEFAULT);
		
		       
		      List<ScreenRegion> r = s.findAll(imageTarget);
		
		      if (r != null) {
			   Mouse mouse = new DesktopMouse();
			   for (int i = 0; i < r.size(); i++) {
				   //System.out.print("Finded : ");
		           mouse.click(r.get(i).getCenter());
		           Point p = MouseInfo.getPointerInfo().getLocation();
		           if (362 <= p.x && p.x <= 848) {
		       			if (234 <= p.y && p.y <= 720) {
		           //System.out.println("x : "+p.x+" | y : "+p.y);
		       				determinePostition(p.x, p.y, image);
		       			}
		           }
			   }
		      } else {
		    	  System.out.print("Not find");
			}
		 }
		 printBoard(board); 
   		
    	 return board;
    }
    
    
    public static void determinePostition(int x, int y, int value) {
    	if (362 <= x && x <= 848) {
    		if (234 <= y && y <= 720) {
    			int column = (x-386)/54;
		    	int row = (y-258)/54;
		    	//System.out.println("row : "+row+" | column : "+column);
		    	board[row][column] = value;
    		}
    	}
    }
    
    private static void printBoard(int[][] board) {
  	  for (int row = 0; row < 9; row++) {
  	    if (row % 3 == 0 && row != 0) {
  	      System.out.println("-----------");
  	    }
  	    for (int column = 0; column < 9; column++) {
  	      if (column % 3 == 0 && column != 0) {
  	        System.out.print("|");
  	      }
  	      System.out.print(board[row][column]);
  	    }
  	    System.out.println();
  	  }
  	  System.out.println();
  	  System.out.println();
  	}
}