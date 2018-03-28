import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

/*************************************************
* @author Gloire Rubambiza
* @since 03/10/2017
**************************************************/
public class InformationPanel extends JPanel {

  /** Objects of the class are now serializable. */
  private static final long serialVersionUID = 1L;

  /** The font for user commands the GUI. */
  private static final Font NORMAL_FONT =
  new Font("Cooper Black", Font.BOLD, 20);

  /** The font for user commands the GUI. */
  private static final Font VICTIM_FONT =
  new Font("Cooper Black", Font.BOLD, 15);

  /** The panel for the commands. */
  private JPanel info;

  /** The label for the memory reference. */
  private JLabel key, plainLetter, cipherAlphabet;


  /** The dimensions for the grid. */
  private final int col = 3, row = 1;

  /** The dimensions for the buttons. */
  private final int width = 200, height = 75;

  /*******************************************************
  * Instantiates the buttons to be used for user actions.
  *******************************************************/
  public InformationPanel () {

    super();

    info = new JPanel();

    key = new JLabel("Key: ");
    key.setPreferredSize(new Dimension(width,height));

    plainLetter = new JLabel("Plain Text Letter: ");
    plainLetter.setPreferredSize(new Dimension(width,height));

    cipherAlphabet = new JLabel("Cipher Alphabet: ");
    cipherAlphabet.setPreferredSize(new Dimension(width,height));

    // exit = new JButton("Exit");

    setStandards();

    // Define the layout.
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    setPreferredSize(new Dimension(300,100));

    // Add the components.
    add(key);
    add(plainLetter);
    add(cipherAlphabet);

    setVisible(true);
  }

  // /*******************************************
  // * Sends the action buttons to the GUI to be
  // * passed to the controller.
  // * @return an array of the action buttons.
  // ********************************************/
  // public JButton [] sendButtons () {
  //   JButton [] actionButtons = new JButton[4];
  //   actionButtons[0] = next;
  //   actionButtons[1] = runf;
  //   actionButtons[2] = runc;
  //   actionButtons[3] = exit;
  //   return actionButtons;
  // }

  /**************************************
  * Sets some aesthetics for the panel.
  ***************************************/
  private void setStandards () {

    Border line = BorderFactory.createLineBorder(Color.WHITE, 2, true);
    key.setFont(NORMAL_FONT);
    plainLetter.setBorder(line);
    plainLetter.setFont(NORMAL_FONT);
    plainLetter.setBorder(line);
    plainLetter.setForeground(Color.GREEN);
    cipherAlphabet.setFont(NORMAL_FONT);
    cipherAlphabet.setBorder(line);
  }

  // /*******************************************
  // * Updates the latest LRU victim.
  // * @param vic is info about the victim that was picked.
  // ********************************************/
  // public void setVictim( int [] vic ) {
  //   int frame = vic[0];
  //   int pid = vic[1];
  //   int page = vic[2];
  //   victim.setText("LRU Victim:" +  " P" + pid + " Page " + page );
  //   victim.setForeground(Color.RED);
  // }
  //
  // /**************************************************
  // * Resets the label for the memory reference
  // * based on the input.
  // * @param pid is the process that made a reference.
  // * @param page is the page that was referenced.
  // **************************************************/
  // public void setReference ( int pid, int page ) {
  //   ref.setText("P" + pid + " referenced page " + page);
  // }
}
