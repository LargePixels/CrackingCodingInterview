package net.largepixels.crackingcodinginterview.ch01;

import java.util.Arrays;

/**
 * Created by johnminchuk on 2/5/16.
 */
public class Ch01Ex03 {

    private void runMe() {
        String a = "addNodesIter";
        String b = "dsfa";

        Boolean isPerm1 = isPermutationBySort(a, b);
        System.out.printf("Is %s a permutation of %s :  %b \n", a, b, isPerm1);

        Boolean isPerm2 = isPermutationBinary(a, b);
        System.out.printf("Is %s a permutation of %s :  %b \n", a, b, isPerm2);

    }

    ///////////////////////////
    // solution 1
    ///////////////////////////

    private Boolean isPermutationBySort(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        return sortString(a).equals(sortString(b));
    }

    private String sortString(String str) {
        char[] charStr = str.toCharArray();
        Arrays.sort(charStr);
        return String.valueOf(charStr);
    }

    ///////////////////////////
    // solution 2
    ///////////////////////////

    private Boolean isPermutationBinary(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int[] counter = new int[256];

        for (int i = 0; i < charA.length; i++) {
            int asciiNum = (int) charA[i];
            counter[asciiNum]++;
        }

        //great little trick to avoid comparing two arrays, decrement the first
        for (int i = 0; i < charB.length; i++) {
            int asciiNum = (int) charB[i];
            counter[asciiNum]--;
            if ( counter[asciiNum] < 0 ) {
                return false;
            }
        }

        return true;
    }

    ///////////////////////////
    // main
    ///////////////////////////

    public static void main(String args[]) {
        Ch01Ex03 ch01Ex03 = new Ch01Ex03();
        ch01Ex03.runMe();
    }

}
