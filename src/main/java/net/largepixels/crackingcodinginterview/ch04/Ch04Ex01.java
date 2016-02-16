package net.largepixels.crackingcodinginterview.ch04;

import net.largepixels.interviewstructures.nodes.tree.BTreePrinter;
import net.largepixels.interviewstructures.nodes.tree.Node;

/**
 * Created by johnminchuk on 2/16/16.
 */
public class Ch04Ex01 {

    private void runMe() {
        Node head1 = Node.treeFromArray(new Integer[]{5, 3, 2, 4, 8, 7, 6, 9});
        BTreePrinter.printNode(head1);
        System.out.println("Is tree balanced at node 5: " + isBalanced(head1) + "\n\n");

        Node head2 = Node.findNodeIter(head1, 3);
        BTreePrinter.printNode(head2);
        System.out.println("Is tree balanced at node 3: " + isBalanced(head2) + "\n\n");

        Node head3 = Node.findNodeIter(head1, 8);
        BTreePrinter.printNode(head3);
        System.out.println("Is tree balanced at node 8: " + isBalanced(head3));

    }

    private boolean isBalanced(Node head) {
        if ( head == null ) {
            return true;
        }

        int left = getTreeDepth(head.left);
        int right = getTreeDepth(head.right);

        if ( left == right ) {
            return isBalanced(head.left) && isBalanced(head.right);
        }
        else {
            return false;
        }
    }

    private int getTreeDepth(Node tree) {

        if ( tree == null ) {
            return 0;
        }

        return 1 + Math.max(getTreeDepth(tree.left), getTreeDepth(tree.right));
    }

    public  static  void main(String args[]) {
        Ch04Ex01 ch04Ex01 = new Ch04Ex01();
        ch04Ex01.runMe();
    }

}
