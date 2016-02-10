package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.Node;
import net.largepixels.crackingcodinginterview.common.NodeUtils;

/**
 * Created by johnminchuk on 2/10/16.
 */
public class Ch02Ex03 {

    private void runMe() {
        Node head = NodeUtils.singlyDupedList();
        Node node = NodeUtils.getNodeAtPosition(head, 4);

        NodeUtils.printList(head);
        System.out.println("We will delete node: " + node.value);

        deleteNodeAt(node);

        NodeUtils.printList(head);

        node = NodeUtils.getNodeAtPosition(head, 7);
        System.out.println("We will delete node: " + node.value);


        deleteNodeAt(node);
    }

    private void deleteNodeAt(Node node) {
        if (node.next == null) {
            System.out.println("We can't delete the last node with this method");
        }

        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }

//    private void deleteNodeAt(Node node) {
//        Node current = node;
//        while ( current != null ) {
//            if (current.next != null) {
//                current.value = current.next.value;
//                current.next = current.next.next;
//            }
//
//            current = current.next;
//        }
//    }

//    private void deleteNodeAt(Node head, Node deleteNode) {
//        Node current = head;
//        Node previous = null;
//        while (current != null) {
//            if (current == deleteNode) {
//                previous.next = current.next;
//            }
//            previous = current;
//            current = current.next;
//        }
//    }

    public static void main(String args[]) {
        Ch02Ex03 ch02Ex03 = new Ch02Ex03();
        ch02Ex03.runMe();
    }
}
