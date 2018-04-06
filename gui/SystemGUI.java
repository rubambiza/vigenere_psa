package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

/***************************************************
* @author Gloire Rubambiza
* @since 03/10/2017
**************************************************/
public class SystemGUI extends JFrame {

  /** Objects of the class are now serializable. */
  private static final long serialVersionUID = 1L;


  // /** Panel for the frame table */
  // private JFrame mainFrame;

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
  *****************************************************/
  public SystemGUI() {

    super();
    // mainFrame = new JFrame();
    info = new InformationPanel();
    command = new CommandPanel();
    vSquare = new VigenereSquarePanel();
    setTitle("Vigenere PSA Project");
    setSize(1500, 1500);
    setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
    add(info);
    add(vSquare);
    add(command);
    setBoundaries();
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }

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
}
