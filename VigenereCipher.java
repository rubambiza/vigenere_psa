/*******************************************************************************
 * @author Colin Smith
 * @since 3/28/2018
 * ****************************************************************************/

import java.util.Arrays;

/******************************************************************************
 * Main engine for the vig cipher visualization project
 * ***************************************************************************/
public class VigenereCipher {

    int encCnt = 0;
    int decCnt = 0;

    public static void main(String[] args) {
      String key = "VIGENERECIPHER";
      String ori = "Sally sells sea shells down by the sea shore.";
      System.out.println("String: " + ori + "\nKey: " + key);

      VigenereCipher vig = new VigenereCipher();
      char[][] board = new char[26][26];
      vig.generateBoard(board);

      String enc = encrypt(ori, key);
      System.out.println("Encrypted Message: " + enc);
      System.out.println("Decrypted message: " + decrypt(enc, key));
    }

    /***************************************************************************
    * generateBoard
    * Generates a text based board which will be used as a stepping stone
    * for our gui based board later.
    * @param encBoard is the 2d char array used to visualize the V Cipher
    ***************************************************************************/
    public void generateBoard(char[][] encBoard){
      int disp = 26, intToChar = 0;
      char spot;
      for(int i = 25; i>-1; i--){
        for(int j = 0; j<26; j++){
          intToChar = j + 65 + disp;
          if(intToChar >= 91){
            intToChar = intToChar - 26;
          }
          spot = (char)(intToChar);
          encBoard[i][j] = spot;
        }
        disp--;
      }

      for(int i=0;i<26;i++){
        for(int j=0;j<26;j++){
          System.out.print(encBoard[i][j] + "  ");
        }
        System.out.println();
      }
    }

    /*
    for each character {
      board is default colors
      pass characterToEncrypt, pass spotInKeyString
      highlight column and row
      return encryptedCharacter
      display encryptedCharacter
      wait for user to press enter
    }
    */

    static void encChar(char character, final String key, char[][] board){
    }

    static String encrypt(String text, final String key, int spotInKey) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
            // if (slowEncrypt) {
            //   while(true) {
            //     if (continue.clicked())
            //     break;
            //   }
            // }
        }
        return res;
    }

    static String decrypt(String text, final String key) {
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
