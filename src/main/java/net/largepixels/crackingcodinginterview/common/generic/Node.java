package net.largepixels.crackingcodinginterview.common.generic;

/**
 * Created by johnminchuk on 2/10/16.
 */
public class Node<T> {

    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T v) {
        value = v;
    }

    public Node(T v, Node<T> n) {
        value = v;
        next = n;
    }

    public T getValue() {
        return value;
    }

    public static <T> void printList(Node<T> head) {
        Node<T> current = head;

        StringBuffer sb = new StringBuffer();
        while ( current != null ) {
            sb.append(current.value);
            sb.append(" -> ");
            current = current.next;
        }
        sb.replace(sb.length() - 3, sb.length(), "");

        System.out.println(sb.toString());
    }


    public static <T> Node<T> listFromArray(T[] items) {

        Node<T> head = null;
        Node<T> end = null;
        for (T value : items) {
            if ( head == null ) {
                head = new Node<T>(value);
                end = head;
            }
            else {
                end.next = new Node<T>(value);
                end = end.next;
            }
        }

        return head;
    }

    public static <T> void loopIt(Node<T> head, int loopStartIndex) {
        Node current = head;
        Node end = null;
        while ( current != null ) {
            if ( current.next == null ) {
                end = current;
            }
            current = current.next;
        }

        current = head;
        for (int i = 0; i < loopStartIndex - 1; i++) {
            current = current.next;
        }
        end.next = current;
    }


}
