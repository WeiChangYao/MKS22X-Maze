import java.util.*;
import java.io.*;
public class Maze{
    private int count;
    private char[][]maze;
    private boolean animate;
    public static char[][] getFile(String fileName) throws FileNotFoundException{
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      ArrayList<String> scanFile = new ArrayList<String>();
      while (in.hasNextLine()){
        scanFile.add(in.nextLine());   //adds lines to array list
      }
      int size = scanFile.size();
      int sizeTwo = scanFile.get(0).length();
      char[][] file = new char[size][sizeTwo];
      for(int i = 0; i < size; i++){
        for(int j = 0; j < sizeTwo; j++){
          file[i][j] = scanFile.get(i).charAt(j);  //convert arrayList into a 2d array char by char
        }
      }
      return file;
    }
    public Maze(String filename) throws FileNotFoundException{
      int count = 0;
      char[][]maze = getFile(filename);
      boolean animate = false;
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
          if (maze[i][j] == 'S'){
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
        if (maze[row-1][col] == 'E'){
          return count;            //if it's E, return count
        }
        if (maze[row+1][col] == 'E'){
          return count;
        }
        if (maze[row][col-1] == 'E'){
          return count;
        }
        if (maze[row][col+1] == 'E'){
          return count;
        }
      boolean stuck = false;
      while(stuck == false){     //while it is not stuck
        if (maze[row-1][col] == ' '){
          maze[row-1][col]='@';     //go down and see if the space is blank
          count++;                  //add an @ and increase count
          return solve(row-1,col);  //continue solving starting from the new space
        }
        if (maze[row+1][col] == ' '){
          maze[row+1][col]='@';
          count++;
          return solve(row+1,col);
        }
        if (maze[row][col-1] == ' '){
          maze[row][col-1]='@';
          count++;
          return solve(row,col-1);
        }
        if (maze[row][col+1] == ' '){
          maze[row][col+1]='@';
          count++;
          return solve(row,col+1);
        }
        stuck = true;              //if none of the direction has an empty space, stuck turns true
      }
      while(stuck = true){
        if (maze[row-1][col] == '@'){  //searches for an @
          maze[row-1][col]='.';        //if there's an @, it becomes '.'
          count--;
          return solve(row-1,col);     //starts solving with new direction
        }
        if (maze[row+1][col] == '@'){
          maze[row+1][col]='.';
          count--;
          return solve(row+1,col);
        }
        if (maze[row][col-1] == '@'){
          maze[row][col-1]='.';
          count--;
          return solve(row,col-1);
        }
        if (maze[row][col+1] == '@'){
          maze[row][col+1]='.';
          count--;
          return solve(row,col+1);
        }
        return -1;
      }
    //********
      /*if(animate){
        clearTerminal();
        System.out.println(this);
        wait(20);
      } */
      return -1;
    }

	public static void main(String[] args)  throws FileNotFoundException{

		try {
			Maze m = new Maze("Maze1.txt");
			//m.solve();
			System.out.println(m);

		} catch (FileNotFoundException e) {}
	}
  
}
