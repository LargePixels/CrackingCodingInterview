package net.largepixels.crackingcodinginterview.ch01;

import net.largepixels.crackingcodinginterview.util.UtilMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnminchuk on 2/7/16.
 */
public class Ch01Ex07 {

    private void runMe() {
        int[][] mtx1 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
        };

        UtilMethods.printMatrix(mtx1);

        zeroIt(mtx1);

        UtilMethods.printMatrix(mtx1);
    }

    private void zeroIt(int[][] mtx) {
        int xPoint = -1;
        int yPoint = -1;

        for (int y = 0; y < mtx.length; y++) {
            for (int x = 0; x < mtx[0].length; x++) {
                if (mtx[y][x] == 0) {
                    xPoint = x;
                    yPoint = y;
                }
            }
        }

        if ( xPoint == -1 ) {
            return;
        }

        for (int y = 0; y < mtx.length; y++) {
            for (int x = 0; x < mtx[0].length; x++) {
                if ( y == yPoint ) {
                    mtx[y][x] = 0;
                }
                else if ( x == xPoint ) {
                    mtx[y][x] = 0;
                }
            }
        }
    }


    public static void main(String args[]) {
        Ch01Ex07 ch01Ex07 = new Ch01Ex07();
        ch01Ex07.runMe();
    }

}
