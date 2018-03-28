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
public class CommandPanel extends JPanel {

  /** Objects of the class are now serializable. */
  private static final long serialVersionUID = 1L;

  /** The font for user commands the GUI. */
  private static final Font NORMAL_FONT =
  new Font("Cooper Black", Font.BOLD, 20);

  /** The font for user commands the GUI. */
  private static final Font VICTIM_FONT =
  new Font("Cooper Black", Font.BOLD, 15);

  /** The panel for the commands. */
  private JPanel command;

  /** The array of action buttons. */
  private JButton nextEncryption, exit;


  /** The dimensions for the grid. */
  private final int col = 3, row = 1;

  /** The dimensions for the buttons. */
  private final int width = 200, height = 75;

  /*******************************************************
  * Instantiates the buttons to be used for user actions.
  *******************************************************/
  public CommandPanel () {

    super();

    command = new JPanel();

    nextEncryption = new JButton("Next Encryption");
    nextEncryption.setPreferredSize(new Dimension(width,height));

    exit = new JButton("Exit");
    exit.setPreferredSize(new Dimension(width,height));

    setStandards();
    add(nextEncryption);
    add(exit);

    // Define the layout.
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    setPreferredSize(new Dimension(800,100));

    setVisible(true);
  }

  /**************************************
  * Sets some aesthetics for the panel.
  ***************************************/
  private void setStandards () {

    Border line = BorderFactory.createLineBorder(Color.WHITE, 2, true);
    nextEncryption.setFont(NORMAL_FONT);
    nextEncryption.setBorder(line);
    exit.setFont(NORMAL_FONT);
    exit.setBorder(line);
    exit.setForeground(Color.RED);
  }

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
