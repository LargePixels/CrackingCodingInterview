package net.largepixels.crackingcodinginterview.ch04;

import net.largepixels.interviewstructures.nodes.tree.BTreePrinter;
import net.largepixels.interviewstructures.nodes.tree.Node;

/**
 * Created by johnminchuk on 2/17/16.
 */
public class Ch04Ex03 {

    private void runMe() {
        int[] values = new int[]{1,2,3,4,5,6,7,8};


        Node root1 = splitInsert(values, 0, values.length - 1);
        BTreePrinter.printNode(root1);

        Node root2 = splitInsertIter(values);
        BTreePrinter.printNode(root2);
    }

    //oops!  this creates a fairly large tree, another reason to go ahead and solve this by hand first, then translate to code...
    private Node splitInsertIter(int[] arr) {
        Node rtn = null;

        if ( arr.length % 2 != 0 ) {    //odd num items
            rtn = Node.insert(rtn, new Node(arr[arr.length/2]));
        }

        int rightStart = arr.length / 2;
        int leftStart = rightStart - 1;

        while ( rightStart < arr.length  ) {
            rtn = Node.insert(rtn, new Node(arr[leftStart]));
            rtn = Node.insert(rtn, new Node(arr[rightStart]));

            leftStart--;
            rightStart++;
        }

        return rtn;
    }

    private Node splitInsert(int[] arr, int start, int end) {
        if ( end < start ) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = splitInsert(arr, start, mid - 1);
        n.right = splitInsert(arr, mid + 1, end);

        return n;
    }

    private Node shortTree(int[] values) {

        int lastIndex = values.length - 1;
        int startIndex = 0;
        int mid = values.length / 2;

        int count = 0;

        while ( count < mid ) {

            count++;
        }

        return null;
    }

    public static void main(String args[]) {
        Ch04Ex03 ch04Ex03 = new Ch04Ex03();
        ch04Ex03.runMe();
    }

}
