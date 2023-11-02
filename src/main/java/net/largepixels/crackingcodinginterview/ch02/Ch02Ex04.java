package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.Node;
import net.largepixels.crackingcodinginterview.common.NodeUtils;

import java.util.Stack;

/**
 * Created by johnminchuk on 2/10/16.
 */
public class Ch02Ex04 {

    private void runMe() {
        Node head = NodeUtils.singlyDupedList();
        NodeUtils.printList(head);

        Node partitioned = partitionAround(head, "c");

        NodeUtils.printList(partitioned);
    }

    private Node partitionAround(Node head, String d) {
        Stack<Node> lessThan = new Stack();
        Stack<Node> greaterThan = new Stack();

        while (head != null) {
            int cur = (int) head.value.toCharArray()[0];
            int val = (int) d.toCharArray()[0];

            if ( cur < val ) {
                lessThan.push(head);
            }
            else {
                greaterThan.push(head);
            }

            head = head.next;
        }

        Node startLt = null;
        Node endLt = null;
        while (!lessThan.empty()) {
            if ( startLt == null ) {
                startLt = lessThan.pop();
                endLt = startLt;
            }
            else {
                endLt.next = lessThan.pop();
                endLt = endLt.next;
            }
        }
        endLt.next = null;

        Node startGt = null;
        Node endGt = null;
        while (!greaterThan.empty()) {
            if ( startGt == null ) {
                startGt = greaterThan.pop();
                endGt = startGt;
            }
            else {
                endGt.next = greaterThan.pop();
                endGt = endGt.next;
            }
        }
        endGt.next = null;

        endLt.next = startGt;
        return startLt;
    }


    public static void main(String args[]) {
        Ch02Ex04 ch02Ex04 = new Ch02Ex04();
        ch02Ex04.runMe();

    }

}
