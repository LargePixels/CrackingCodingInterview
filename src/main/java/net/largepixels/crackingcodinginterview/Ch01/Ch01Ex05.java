package net.largepixels.crackingcodinginterview.ch01;

/**
 * Created by johnminchuk on 2/5/16.
 */
public class Ch01Ex05 {

    private void runMe() {
        String str1 = "aabccccaaa";
        String compressed1 = compress1(str1);
        System.out.println(str1);
        System.out.println(compressed1);

        System.out.println("------------------------");

        String str2 = "abc";
        String compressed2 = compress1(str2);
        System.out.println(str2);
        System.out.println(compressed2);
    }

    private String compress1(String str) {
        char[] chrArr = str.toCharArray();

        if ( compressedSize(chrArr) >= str.length() ){
            return str;
        }

        StringBuffer sb = new StringBuffer();

        char current = chrArr[0];
        int count = 0;
        for (int i = 0; i < chrArr.length; i++ ) {
            if (chrArr[i] == current) {
                count++;
            }
            else {
                sb.append(current);
                sb.append(count);
                count = 1;
                current = chrArr[i];
            }
        }

        sb.append(current);
        sb.append(count);
        return sb.toString();
    }

    private int compressedSize(char[] chrArr) {
        int count = 2;
        char current = chrArr[0];
        for (int i = 0; i < chrArr.length; i++) {
            if (current == chrArr[i])  {

            }
            else {
                current = chrArr[i];
                count++;
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        Ch01Ex05 ch01Ex05 = new Ch01Ex05();
        ch01Ex05.runMe();
    }

}
