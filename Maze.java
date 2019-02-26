import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
public class Maze{
  public ArrayList getfile(String fileName) throws FileNotFoundException{
    File f = new File(fileName);
    Scanner in = new Scanner(f);
    ArrayList<String> scanFile = new ArrayList<String>();
    while (in.hasNext()){
      scanFile.add(in.next());
    }
    return scanFile;
  }
  public static void main(String args[]){
    ArrayList<String> a = new ArrayList<String>();
    a = getfile(Maze1);
  }
}
