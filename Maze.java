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
    public String toString(){
      String str = "";
      for (int i =0;i < maze.length;i++){
        for (int j=0; j<maze[0].length;j++){
          str+= maze[i][j];
        }
        str+= "\n";
      }
      return str;
    }
    public int solve(){
      int startR = 0;
      int startC = 0;
      for (int i =0;i < maze.length;i++){
        for (int j=0; j<maze[0].length;j++){
          if (maze[i][j] = S){
            startR = i;
            startC = j;
            maze[i][j] = '@';
          }
        }
      }
      return solve(startR,startC);
    }


    private int solve(int row, int col){
    //********
      boolean stuck = false;
      while(stuck == false){
        if (maze[row-1][col] == ' '){
          maze[row-1][col]=='@';
          return solve(row-1,col);
        }
        if (maze[row+1][col] == ' '){
          maze[row+1][col]=='@';
          return solve(row+1,col);
        }
        if (maze[row][col-1] == ' '){
          maze[row][col-1]=='@';
          return solve(row,col-1);
        }
        if (maze[row][col+1] == ' '){
          maze[row][col+1]=='@';
          return solve(row,col+1);
        }
      }
    //********
      if(animate){
        clearTerminal();
        System.out.println(this);
        wait(20);
      }
      return -1;
    }



    public static void main(String args[]){
      char[][] a = new char[][];
      a = getFile("Maze1.txt");
    }
}
