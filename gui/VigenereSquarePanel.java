package gui;

import vigenerCipher.VigenereCipher;

import javax.swing.*;
import javax.swing.border.Border;
;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

/***************************
* @author Gloire Rubambiza
* @since 03/10/2017
***************************/
public class VigenereSquarePanel extends JPanel {

  /** Objects of the class are now serializable. */
  private static final long serialVersionUID = 1L;

  /** The font for user commands the GUI. */
  private static final Font NORMAL_FONT =
  new Font("Cooper Black", Font.BOLD, 20);

  /** The panel for the commands. */
  private JPanel vSquare;

  /** The label for the memory reference. */
  private static JLabel [][] alphabetSquare;

  /** The dimensions for the grid. */
  private static final int col = 26, row = 26;

  /** The dimensions for the labels. */
  private final int width = 20, height = 20;

  /*******************************************************
  * Instantiates the buttons to be used for user actions.
  *******************************************************/
  public VigenereSquarePanel () {

    super();

    vSquare = new JPanel();
    setLayout(new GridLayout(row,col));
    setPreferredSize(new Dimension(540,520));

    char[][] board = VigenereCipher.generateBoard(new char[row][col]);
    alphabetSquare = new JLabel[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        alphabetSquare[i][j] = new JLabel("X", (int) CENTER_ALIGNMENT);
        alphabetSquare[i][j].setText(Character.toString(board[i][j]));
        alphabetSquare[i][j].setPreferredSize(new Dimension(width,height));
        setStandards(alphabetSquare[i][j]);
        alphabetSquare[i][j].setOpaque(true);
        add(alphabetSquare[i][j]);
      }
    }
    setVisible(true);
  }

  /**************************************
  * Sets some aesthetics for the labels.
  ***************************************/
  private void setStandards (JLabel label) {

    Border line = BorderFactory.createLineBorder(Color.WHITE, 2, true);
    label.setFont(NORMAL_FONT);
    label.setBorder(line);
  }

  public static void resetBoard() {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        alphabetSquare[i][j].setBackground(null);
      }
    }
  }

  public static void highlightSquares(int xAxis, int yAxis) {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (j == xAxis || i == yAxis) {
          alphabetSquare[i][j].setBackground(Color.YELLOW);
        }
        if (j == xAxis && i == yAxis) {
          alphabetSquare[i][j].setBackground(Color.RED);
        }
      }
    }
  }
}
