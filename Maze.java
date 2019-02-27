import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;
    public char[][] getFile(String fileName) throws FileNotFoundException{
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      char[][] scanFile = new char[][];
      for (int i = 0; i < c)
      return scanFile;
    }
    public static void main(String args[]){
      char[][] a = new char[][];
      a = getFile("Maze1.txt");
    }
}
