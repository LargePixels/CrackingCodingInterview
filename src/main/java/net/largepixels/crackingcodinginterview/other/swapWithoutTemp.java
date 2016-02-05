package net.largepixels.crackingcodinginterview.other;

/**
 * Created by johnminchuk on 2/5/16.
 */
public class swapWithoutTemp {

    public static void main(String args[]) {
        int a = 3;
        int b = 2;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println("swap em!");

        a = a + b;      //a now 5
        b = a - b;      //b now 3
        a = a - b;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}