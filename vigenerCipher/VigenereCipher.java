package vigenerCipher;

/*******************************************************************************
 * @author Colin Smith
 * @since 3/28/2018
 * ****************************************************************************/

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/******************************************************************************
 * Main engine for the vig cipher visualization project
 * ***************************************************************************/
public class VigenereCipher {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    int encCnt = 0;
    int decCnt = 0;


    public static void main(String[] args) {
      //is true if the user wants to continue seeing how the process works
      boolean slowEncrypt = true;

      //THESE'LL NEED TO BE REPLACED WITH THE GUI INPUT
      String key = "VIGENERECIPHER";
      String ori = "Bums";
      System.out.println("String: " + ori + "\nKey: " + key);

      VigenereCipher vig = new VigenereCipher();
      char[][] board = new char[26][26];
      vig.generateBoard(board);

      String enc = encrypt(ori, key, slowEncrypt, board);
      System.out.println("Encrypted Message: " + enc);
      System.out.println("Decrypted message: " + decrypt(enc, key));
    }

    /***************************************************************************
    * generateBoard
    * Generates a text based board which will be used as a stepping stone
    * for our gui based board later.
    * @param encBoard is the 2d char array used to visualize the V Cipher
    ***************************************************************************/
    public static char[][] generateBoard(char[][] encBoard){
      //Displacement is used to make the incrementing aspect of the board
      //IntToChar holds the current value of the next letter on the board
      int disp = 26, intToChar = 0;

      //Puts the board into memory
      for(int i = 25; i>-1; i--){
        for(int j = 0; j<26; j++){
          intToChar = j + 65 + disp;

          //if greater than 'Z', swap it to 'A'
          if(intToChar >= 91){
            intToChar = intToChar - 26;
          }

          //add char to current spot on board
          encBoard[i][j] = (char)(intToChar);
        }
        disp--;
      }
      return encBoard;
    }


    /***************************************************************************
    * printBoard
    * Prints a text based board which will be used as a stepping stone
    * for our gui based board later.
    * KEY IS I, TEXT IS J
    * @param encBoard is the 2d char array used to visualize the V Cipher
    * @param xAxis coordinate for j in the double for loop - used for IDing selected column
    * @param yAxis coordinate for i in the double for loop - used for IDing selected row
    ***************************************************************************/
    public static void printBoard(char[][] encBoard, int xAxis, int yAxis){
      for(int i=0;i<26;i++){
        for(int j=0;j<26;j++){
          if(i == yAxis && j == xAxis) //Intersection
            System.out.print(ANSI_RED + encBoard[i][j] + "  " + ANSI_RESET); //red text
          else if(i == yAxis || j == xAxis) //row/col
            System.out.print(ANSI_GREEN + encBoard[i][j] + "  " + ANSI_RESET); //green text
          else
            System.out.print(encBoard[i][j] + "  "); //white text
        }
        System.out.println(); //new row
      }
      System.out.println(); //end of board
    }

    /*
    for each character {
      board is default colors ✓
      highlight column and row ✓
      return encryptedCharacter
      display encryptedCharacter ✓
      wait for user to press enter
    }
    */



    public static String encrypt(String text, final String key, boolean flag, char[][] encBoard) {
        int counter = 0; //used for checking spot in the key and plaintext
        String res = "";
        text = text.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');

            //if the flag is true, print the board and wait for button click
            if (flag) {
              //grabs letter equivalents for the characters
              int xAxis = text.charAt(i) - 65;
              //since the yAxis starts with B at the top, it needs a displacement
              int yAxis = key.charAt(j) - 65 - 1;

              j = ++j % key.length();

              printBoard(encBoard, xAxis, yAxis);

/************************************************************************
* WAIT FOR THE BUTTON CLICK HERE
************************************************************************/
              // while(true) {
              //   // NEED A FLAG BUTTON HERE
              //   // if (continue.clicked())
              //   // break;
              // }
            }
        }
        return res;
    }

    public static String decrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
}
