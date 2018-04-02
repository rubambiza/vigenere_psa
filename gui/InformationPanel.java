package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
;
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
    plainLetter = new JLabel("Plain Text Letter: ");
    cipherAlphabet = new JLabel("Cipher Alphabet: ");
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

  /**************************************
  * Sets some aesthetics for the panel.
  ***************************************/
  private void setStandards () {

    Border line = BorderFactory.createLineBorder(Color.WHITE, 2, true);
    key.setFont(NORMAL_FONT);
    key.setBorder(line);
    plainLetter.setBorder(line);
    plainLetter.setFont(NORMAL_FONT);
    plainLetter.setForeground(Color.GREEN);
    cipherAlphabet.setFont(NORMAL_FONT);
    cipherAlphabet.setBorder(line);
    cipherAlphabet.setForeground(Color.YELLOW);
  }
}
