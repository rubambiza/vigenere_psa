import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.util.Queue;
import java.util.LinkedList;
/******************************************************
* Main entry into the program.
* @author Gloire Rubambiza
* @since 03/10/2017
******************************************************/
public class Main {

  public static void main (String[] args) {

    // String filename = "";
    // FileChoice chooser = new FileChoice();
    // filename = chooser.chooseFile();
    // Tables tbl = new Tables();
    SystemGUI gui = new SystemGUI();
    // Queue<Integer[]> myQ = new LinkedList<Integer[]>();
    //
    // try  {
    //   BufferedReader reader = new BufferedReader(new FileReader(filename));
    //   String line  = null;
    //
    //   while ( (line = reader.readLine() ) != null) {
    //     sanitizeInput(line, myQ);
    //   }
    // } catch ( IOException e) {
    //   System.err.println("Could not find input file.\n");
    //   e.printStackTrace();
    //   System.exit(1);
    // }
    //
    // // Send the controller to handle the input.
    // Controller ctrl = new Controller(gui, tbl, myQ);
  }
}
