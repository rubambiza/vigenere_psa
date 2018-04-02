package gui;

import vigenerCipher.VigenereCipher;

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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


  /** The panel for the commands. */
  private JPanel command;

  /** The panel for user input. */
  private InputPanel input;

  /** The array of action buttons. */
  private JButton nextEncryption, runToCompletion, exit;

  /** The dimensions for the grid. */
  private final int col = 2, row = 1;

  /** The dimensions for the buttons. */
  private final int width = 200, height = 75;

  /** The listener for the buttons.*/
  private ButtonListener listener;

  /*******************************************************
  * Instantiates the buttons to be used for user actions.
  *******************************************************/
  public CommandPanel () {

    super();

    listener = new ButtonListener();

    command = new JPanel();
    input = new InputPanel();

    nextEncryption = new JButton("Next Encryption");
    nextEncryption.setPreferredSize(new Dimension(width,height));
    nextEncryption.addActionListener(listener);

    runToCompletion = new JButton("Run to Completion");
    runToCompletion.setPreferredSize(new Dimension(width,height));
    runToCompletion.addActionListener(listener);

    exit = new JButton("Exit");
    exit.setPreferredSize(new Dimension(width,height));
    exit.addActionListener(listener);

    setStandards();
    setLayout(new BorderLayout());
    add(nextEncryption, BorderLayout.WEST);
    add(runToCompletion, BorderLayout.NORTH);
    add(exit, BorderLayout.EAST);
    add(input, BorderLayout.CENTER);

    // Define the layout.
    setPreferredSize(new Dimension(1000,100));
    setVisible(true);
  }

  /**************************************
  * Sets some aesthetics for the panel.
  ***************************************/
  private void setStandards () {

    Border line = BorderFactory.createLineBorder(Color.WHITE, 2, true);
    nextEncryption.setFont(NORMAL_FONT);
    nextEncryption.setBorder(line);
    runToCompletion.setFont(NORMAL_FONT);
    runToCompletion.setBorder(line);
    exit.setFont(NORMAL_FONT);
    exit.setBorder(line);
    exit.setForeground(Color.RED);
    input.setFont(NORMAL_FONT);
    input.setForeground(Color.GRAY);
  }

  private class ButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent actionEvent) {
          if (actionEvent.getSource() == exit) {
              System.exit(1);
          }

          if (actionEvent.getSource() == runToCompletion) {
              String enc = VigenereCipher.encrypt(input.getCleartextString(), input.getKeyString(), false, VigenereCipher.generateBoard(new char[26][26]));
              char[][] arr = VigenereCipher.generateBoard(new char[26][26]);
              for (char[] chars : arr) {
                  System.out.println(chars);
              }
              System.out.println("\n\n\n");
              System.out.println(enc);
          }

          if (actionEvent.getSource() == nextEncryption) {

          }
      }
  }

}
