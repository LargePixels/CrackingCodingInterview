package net.largepixels.crackingcodinginterview.common;

/**
 * Created by johnminchuk on 2/9/16.
 */
public class NodeUtils {

    public static void printList(Node head) {
        Node current = head;

        StringBuffer sb = new StringBuffer();
        while ( current != null ) {
            sb.append(current.value);
            sb.append(" -> ");
            current = current.next;
        }
        sb.replace(sb.length() - 3, sb.length(), "");

        System.out.println(sb.toString());
    }

    /**
     * @return A singly linked list with duplicates
     */
    public static Node singlyDupedList() {
        Node n1 = new Node("a");
        Node n2 = new Node("b");
        Node n3 = new Node("a");
        Node n4 = new Node("c");
        Node n5 = new Node("d");
        Node n6 = new Node("e");
        Node n7 = new Node("a");
        Node n8 = new Node("b");

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        return n1;
    }
}
