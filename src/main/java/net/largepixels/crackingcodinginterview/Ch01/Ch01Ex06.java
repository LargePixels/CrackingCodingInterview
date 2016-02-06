package net.largepixels.crackingcodinginterview.ch01;

/**
 * Created by johnminchuk on 2/5/16.
 */
public class Ch01Ex06 {

    private void runMe() {
        char[][] image1 = {
                {'A', 'B'},
                {'A', 'B'}
        };

        char[][] image2 = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };

        char[][] image3 = {
                {'A', 'B', 'C', 'D'},
                {'A', 'B', 'C', 'D'},
                {'A', 'B', 'C', 'D'},
                {'A', 'B', 'C', 'D'},
        };

        char[][] image4 = {
                {'A', 'B', 'C', 'D', 'E', 'F'},
                {'G', 'H', 'I', 'J', 'K', 'L'},
                {'M', 'N', 'O', 'P', 'Q', 'R'},
                {'S', 'T', 'U', 'V', 'W', 'X'},
                {'Y', 'Z', '1', '2', '3', '4'},
                {'5', '6', '7', '8', '9', '0'}
        };

        printMatrix(image4);

        //char[][] rotated = rotate(image4, 6);
        char[][] rotated = rotateImage(image4);

        printMatrix(image4);

        //char[][] rotated = rotateImage(image2);

        //printMatrix(rotated);

    }

    //book solution...
    public char[][] rotate(char[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for ( int i = first; i < last; ++i ) {
                int offset = i - first;
                char top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first]  = matrix[last][last-offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        return matrix;
    }

    private char[][] rotateImage(char[][] img) {
        int layers = (img.length - 1 ) / 2;

        for (int y = 0; y <= layers; y++) {
            int xStart = (y * 2) / 2;
            int xEnd = (img[y].length - 1) - xStart;
            for ( int x = xStart; x < xEnd; x++) {
                int offset = x - xStart;
                //System.out.println("(" + y + ", " + x + ")");
                //System.out.println("(" + (y+offset) + ", " + xEnd + ")");
                //System.out.println("(" + xEnd + ", " + (xEnd-offset) + ")");
                //System.out.println("(" + (xEnd-offset) + ", " + y + ")");

                char temp1 = img[y][x];
                char temp2 = img[y+offset][xEnd];
                char temp3 = img[xEnd][xEnd-offset];
                char temp4 = img[xEnd-offset][y];

                img[y+offset][xEnd] = temp1;
                img[xEnd][xEnd-offset] = temp2;
                img[xEnd-offset][y] = temp3;
                img[y][x] = temp4;

                System.out.println("----------");

                printMatrix(img);
            }
        }

        return null;

    }

    private void printMatrix(char[][] img) {
        System.out.println("----------");

        for (int y = 0; y < img.length; y++){
            for (int x = 0; x < img[y].length; x++) {
                System.out.print( img[y][x] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) {
        Ch01Ex06 ch01Ex06 = new Ch01Ex06();
        ch01Ex06.runMe();
    }

}
