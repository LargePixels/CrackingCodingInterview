package net.largepixels.crackingcodinginterview.Ch01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by johnminchuk on 2/4/16.
 */
public class Ch01Ex01 {

    private void runMe() {
        String duplicateLetters1 = "abelkjidjal";
        Boolean dupes1 = checkDupesWithHash(duplicateLetters1);
        System.out.println("Has dupes tested with hash? " + dupes1);

        String duplicateLetters2 = "abelkjid";
        Boolean dupes2 = checkDupesWithHash(duplicateLetters2);
        System.out.println("Has dupes tested with hash? " + dupes2);

        String duplicateLetters3 = "abelkjidjal";
        Boolean dupes3 = checkDupesWithHash(duplicateLetters3);
        System.out.println("Has dupes tested with bools? " + dupes3);

        String duplicateLetters4 = "abelkjid";
        Boolean dupes4 = checkDupesWithHash(duplicateLetters4);
        System.out.println("Has dupes tested with bools? " + dupes4);

    }

    public Boolean checkDupesWithHash(String str) {
        Map<Character, Integer> dupeMap = new HashMap<>();

        char[] charStr = str.toCharArray();

        for ( Character currentCharacter : charStr ) {
            Integer storedCharCount = dupeMap.get(currentCharacter);
            if ( storedCharCount == null ) {
                dupeMap.put(currentCharacter, 1);
            }
            else {
                return true;
            }
        }

        return false;
    }

    public Boolean checkDupesBinary(String str) {
        char[] charArray = str.toCharArray();

        Boolean[] charSpot = new Boolean[256];

        for (char theChar : charArray ) {
            int charInt = (int) theChar;
            if (charSpot[charInt]) {
                return true;
            }
        }

        return false;
    }

    ///////////////////////////
    // main
    ///////////////////////////

    public static void main(String[] args) {
        Ch01Ex01 ch01 = new Ch01Ex01();
        ch01.runMe();
    }

}
