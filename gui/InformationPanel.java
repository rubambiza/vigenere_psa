package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
;
import javax.swing.BoxLayout;
import javax.swing.text.Highlighter;

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
  private static JLabel key, plainLetter, cipherAlphabet;

  /** The dimensions for the grid. */
  private final int col = 3, row = 1;

  /** The dimensions for the buttons. */
  private final int width = 200, height = 75;

  /**  The default strings for the display. */
  private static final String keyDisplay = "Key: ", plainTextDisplay = "Plain Text Letter: ", alphabetDisplay = "Cipher Alphabet: ";

  /** The html text used for highlighting a letter. */
 // private static final String highlightBefore = "<html><div style=\"color:green\">", highlightAfter = "</div></html>";

  /*******************************************************
  * Instantiates the buttons to be used for user actions.
  *******************************************************/
  public InformationPanel () {

    super();

    info = new JPanel();

    key = new JLabel(keyDisplay);
    plainLetter = new JLabel(plainTextDisplay);
    cipherAlphabet = new JLabel(alphabetDisplay);
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

  public static void changeDisplayState(String newKey, int keyLetter, String newPlainText, String newAlphabet) {
    char[] t = newKey.toCharArray();
    String formattedTxt = "";
    for (int i = 0; i < t.length; i++) {
      System.out.println(t[i]);
      
      if (t[i] == newKey.charAt(keyLetter)) {
        formattedTxt += String.format("<html><font color=YELLOW>%s</font></html>", t[i]);
      } else {
        formattedTxt += t[i];
      }
    }
    key.setText(formattedTxt);
    System.out.println(formattedTxt);





    plainLetter.setText(plainTextDisplay + newPlainText);
    cipherAlphabet.setText(alphabetDisplay + newAlphabet);
  }
}