package net.largepixels.crackingcodinginterview.Ch01;

/**
 * Created by johnminchuk on 2/5/16.
 */
public class Ch01Ex04 {

    private void runMe() {
        String a = "These spaces should be filled with something";

        String filled = fillSpaces(a);
        System.out.println(a);
        System.out.println(filled);

    }

    private String fillSpaces(String a) {

        char[] aChar = a.toCharArray();

        int spacesCount = 0;
        for (char value : aChar) {
            if (value == ' ') {
                spacesCount++;
            }
        }

        int newLength = aChar.length + (spacesCount * 2);
        char[] rtnStr = new char[newLength];

        int rtnStrPos = 0;
        for ( int i = 0; i < aChar.length; i++ ) {
            if (aChar[i] == ' ') {
                rtnStr[rtnStrPos] = '%';
                rtnStrPos++;
                rtnStr[rtnStrPos] = '2';
                rtnStrPos++;
                rtnStr[rtnStrPos] = '0';
                rtnStrPos++;
            }
            else {
                rtnStr[rtnStrPos] = aChar[i];
                rtnStrPos++;
            }
        }

        return String.valueOf(rtnStr);
    }


    ///////////////////////////
    // main
    ///////////////////////////

    public static void main(String args[]) {
        Ch01Ex04 ch01Ex04 = new Ch01Ex04();
        ch01Ex04.runMe();
    }

}
