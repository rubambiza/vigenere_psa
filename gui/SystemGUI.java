import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.Hashtable;
/***************************************************
* @author Gloire Rubambiza
* @since 03/10/2017
**************************************************/
public class SystemGUI extends JFrame {

  /** Objects of the class are now serializable. */
  private static final long serialVersionUID = 1L;

  //
  // /** Panel for the frame table */
  // private PhysicalStatePanel memory;

   /** Panel for the information. */
   private InformationPanel info;

   /** Panel for the commands. */
   private CommandPanel command;

   /** Panel for the vigenere square. */
   private VigenereSquarePanel vSquare;

  /** The GV blue color. */
  private static final java.awt.Color LAKER_BLUE =
  new java.awt.Color(0, 101, 164);

  /** The row and column for the grid. */
  private final int row = 3, column = 1;

  /*****************************************************
  * Instantiates all the panels representing the system.
  * @param filename is the input file
  *****************************************************/
  public SystemGUI() {

    super();

    info = new InformationPanel();
    command = new CommandPanel();
    vSquare = new VigenereSquarePanel();
    setTitle("Vigenere PSA Project");
    setSize(1040, 1200);
    setLayout(new GridLayout(row,column));
    add(info);
    add(vSquare);
    add(command);
    setBoundaries ();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }

  // /**********************************************
  // * Retrieves the action buttons and passes them
  // * to the controller to add listeners.
  // * @param
  // **********************************************/
  // public JButton [] sendButtons () {
  //   userActionBtns = commands.sendButtons();
  //   return userActionBtns;
  // }
  //
  /*********************************************
  * Sets the backgrounds and borders of panels.
  *********************************************/
  private void setBoundaries () {
    info.setBackground(LAKER_BLUE);

    Border line = BorderFactory.createLineBorder(Color.WHITE, 4, true);
    Border matte = BorderFactory.createRaisedBevelBorder();

    info.setBorder(new CompoundBorder(matte,line));
    command.setBorder(new CompoundBorder(matte,line));
    vSquare.setBorder(new CompoundBorder(matte,line));
  }
  //
  // /***************************************
  // * Passes the page table to be displayed.
  // * @param pTable is the page table.
  // * @param pid is the pid of the process.
  // ****************************************/
  // public void displayPageTable( Hashtable<Integer, Integer> pTable, int pid) {
  //   pageTable.redrawTable(pTable, pid);
  // }
  //
  // /*****************************************************
  // * Gets a reference to the frame table i.e. current
  // * physical state of memory.
  // * Passes the frame table to the physical state panel.
  // * @param fTable is the frame table.
  // * @param fault is the kind of fault.
  // * @param frame is frame that potentiall needs to be
  // * colored for the user.
  // *****************************************************/
  // public void displayFrameTable (Frame [] fTable, boolean fault, int frame) {
  //   memory.redrawTable(fTable, fault, frame);
  // }
  //
  // /**************************************************
  // * Passes the memory reference to the commands panel.
  // * @param pid is the process that made a reference.
  // * @param ref is the page that was referenced.
  // **************************************************/
  // public void displayReference ( int pid, int ref ) {
  //   commands.setReference(pid, ref);
  // }
  //
  // /*********************************************
  // * Passes the array of PCBs to the stats panel.
  // * @param pcbArray is the array of PCBs.
  // *********************************************/
  // public void displayStats ( PCB [] pcbArray ) {
  //   stats.displayFinalStats(pcbArray);
  // }
  //
  // /*****************************************************
  // * Passes the victim to the commands panel.
  // * @param vic is info about the victim that was picked.
  // ******************************************************/
  // public void displayVictim( int [] vic ) {
  //   commands.setVictim(vic);
  // }
}
