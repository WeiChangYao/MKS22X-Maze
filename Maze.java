import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;
    public char[][] getFile(String fileName) throws FileNotFoundException{
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      char[][] scanFile = new char[][];
      for (int i = 0; i < c; i++){

      }
      return scanFile;
    }
    public void setAnimate(boolean b){
      animate = b;
    }
    public void clearTerminal(){
      System.out.println("\033[2J\033[1;1H");
    }



    public static void main(String args[]){
      char[][] a = new char[][];
      a = getFile("Maze1.txt");
    }
}
