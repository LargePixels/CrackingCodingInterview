package net.largepixels.crackingcodinginterview.common;

/**
 * Created by johnminchuk on 2/9/16.
 */
public class Node {
    public String value;
    public Node next;
    public Node prev;

    public Node(String v) {
        value = v;
    }

    public Node(String v, Node n) {
        value = v;
        next = n;
    }

    public Node(String v, Node n, Node p) {
        value = v;
        next = n;
        prev = p;
    }

}
