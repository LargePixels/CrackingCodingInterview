package net.largepixels.crackingcodinginterview.ch01;

/**
 * Created by johnminchuk on 2/4/16.
 */
public class Ch01Ex02 {

    private void runMe() {
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String revStr1 = revStr(str1);
        System.out.println(revStr1);

        String str2 = "abcd";
        String revStr2 = revStr(str2);
        System.out.println(revStr2);
    }

    public String revStr(String str) {
        char[] chrStr = str.toCharArray();

        for (int current = 0; current < chrStr.length / 2; current++) {
            int other = chrStr.length - 1 - current;

            char temp = chrStr[current];
            chrStr[current] = chrStr[other];
            chrStr[other] = temp;
        }

        return String.valueOf(chrStr);

    }

    ///////////////////////////
    // main
    ///////////////////////////

    public static void main(String args[]) {
        Ch01Ex02 ch01Ex02 = new Ch01Ex02();
        ch01Ex02.runMe();
    }

}
