package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.Node;
import net.largepixels.crackingcodinginterview.common.NodeUtils;

/**
 * Created by johnminchuk on 2/9/16.
 */
public class Ch02Ex02 {

    private void runMe() {
        Node head = NodeUtils.singlyDupedList();
        NodeUtils.printList(head);

        Node nToLast = getNthToLastNode(head, 3);
        System.out.println("The 3 to last node iterative is: " + nToLast.value);

        getNthToLastRecursive(head, 3, 0);
    }

    private void getNthToLastRecursive(Node head, int k, int count) {
        if (head.next == null) {
            return;
        }

        count++;
        getNthToLastRecursive(head.next, k, count);

        if ( k == count - k ) {
            System.out.println("The " + k + " to last node recursive is: " + head.value);
        }
    }

    private Node getNthToLastNode(Node head, int n) {
        Node current = head;
        Node runner = head;
        int counter = 1;
        while ( runner != null && counter != n ) {
            runner = runner.next;
            counter++;
        }

        while ( runner != null ) {
            if (runner.next == null) {
                return current;
            }
            current = current.next;
            runner = runner.next;
        }

        return null;
    }

    public static void main(String args[]) {
        Ch02Ex02 ch02Ex02 = new Ch02Ex02();
        ch02Ex02.runMe();
    }
}
