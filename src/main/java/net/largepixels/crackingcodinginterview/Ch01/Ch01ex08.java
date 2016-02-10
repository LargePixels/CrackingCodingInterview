package net.largepixels.crackingcodinginterview.ch01;

/**
 * Created by johnminchuk on 2/7/16.
 */
public class Ch01Ex08 {

    private void runMe() {
        String s1 = "watterbottle";
        String s2 = "terbottlewat";

        Boolean isRotation = isRotation(s1, s2);

        System.out.printf("Is %s a rotation of %s: %b\n", s1, s2, isRotation);
    }

    private Boolean isRotation(String s1, String s2) {
        String s1s1 = s1 + s1;
        if ( s1.length() == s2.length() && s1.length() > 0) {
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private Boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }


    public static void main(String args[]) {
        Ch01Ex08 ch01Ex08 = new Ch01Ex08();
        ch01Ex08.runMe();
    }

}
