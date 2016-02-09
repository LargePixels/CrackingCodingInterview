package net.largepixels.crackingcodinginterview.util;

/**
 * Created by johnminchuk on 2/7/16.
 */
public class UtilMethods {

    public static void printMatrix(char[][] img) {
        System.out.println("----------");

        for (int y = 0; y < img.length; y++){
            for (int x = 0; x < img[y].length; x++) {
                System.out.print( img[y][x] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void printMatrix(int[][] img) {
        System.out.println("----------");

        for (int y = 0; y < img.length; y++){
            for (int x = 0; x < img[y].length; x++) {
                System.out.print( img[y][x] + " ");
            }
            System.out.print("\n");
        }
    }


}
