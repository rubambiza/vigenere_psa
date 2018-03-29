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
  private JTextArea textArea, keyTextArea;

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

    keyTextArea = new JTextArea("Enter plain text");
    JScrollPane keyScroll = new JScrollPane(keyTextArea);
    keyTextArea.setEditable(true);

    textArea = new JTextArea("Enter Key");
    JScrollPane textScroll = new JScrollPane(textArea);
    textArea.setEditable(true);

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
  * Sets some aesthetics for the panel.
  ***************************************/
  private void setStandards () {

    Border line = BorderFactory.createLineBorder(Color.WHITE, 2, true);
    keyTextArea.setFont(NORMAL_FONT);
    keyTextArea.setBorder(line);
    textArea.setFont(NORMAL_FONT);
    textArea.setBorder(line);
  }
}
