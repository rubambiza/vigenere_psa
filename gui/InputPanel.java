package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

/*************************************************
* @author Gloire Rubambiza
* @since 03/10/2017
**************************************************/
public class InputPanel extends JPanel {

  /** Objects of the class are now serializable. */
  private static final long serialVersionUID = 1L;

  /** The font for user commands the GUI. */
  private static final Font NORMAL_FONT =
  new Font("Cooper Black", Font.BOLD, 20);

  /** The panel for the input. */
  private JPanel input;

  /** The text areas for input. */
  private JTextArea clearTextArea, keyTextArea;

  /** The dimensions for the grid. */
  private final int col = 2, row = 2;

  /** The dimensions for the buttons. */
  private final int width = 50, height = 50;

  /*******************************************************
  * Instantiates the buttons to be used for user actions.
  *******************************************************/
  public InputPanel () {

    super();

    input = new JPanel();

    keyTextArea = new JTextArea("Enter Key Text");
    JScrollPane keyScroll = new JScrollPane(keyTextArea);
    keyTextArea.setEditable(true);

    clearTextArea = new JTextArea("Enter Plain Text");
    JScrollPane textScroll = new JScrollPane(clearTextArea);
    clearTextArea.setEditable(true);

    setStandards();

    // Define the layout.
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(300,100));

    // Add the components.
    add(textScroll);
    add(keyScroll);
    setVisible(true);
  }

  /**************************************
   * Returns the key as a String.
   ***************************************/
  public String getKeyString() {
    return keyTextArea.getText().toUpperCase().replace(" ", "");
  }

  /**************************************
   * Returns the cleartext as a String.
   ***************************************/
  public String getCleartextString() {
    return clearTextArea.getText().toUpperCase().replace(" ", "");
  }

  /**************************************
  * Sets some aesthetics for the panel.
  ***************************************/
  private void setStandards () {
    Border line = BorderFactory.createLineBorder(Color.WHITE, 2, true);
    keyTextArea.setFont(NORMAL_FONT);
    keyTextArea.setBorder(line);
    clearTextArea.setFont(NORMAL_FONT);
    clearTextArea.setBorder(line);
  }
}
