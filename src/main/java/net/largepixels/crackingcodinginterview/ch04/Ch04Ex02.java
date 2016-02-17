package net.largepixels.crackingcodinginterview.ch04;


import net.largepixels.interviewstructures.nodes.graph.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by johnminchuk on 2/16/16.
 */
public class Ch04Ex02 {

    private void runMe() {
        //         b
        //       / |
        //     a - c
        //       \ |
        //         e - d

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");

        a.nodes = new Node[]{b, c, e};
        b.nodes = new Node[]{a, c};
        c.nodes = new Node[]{a, b, e};
        d.nodes = new Node[]{e};
        e.nodes = new Node[]{a, c, d};

        FoundClass foundClass = new FoundClass();
        isAccessible(d, b, foundClass);
        System.out.println("Is node D able to reach node B " + foundClass.found);
    }

    class FoundClass {
        boolean found;
    }

    private void isAccessible(Node current, Node end, FoundClass found) {

        System.out.println("visting: " + current.value);
        current.visited = true;

        if ( current == end ) {
            System.out.println("accessible");
            found.found = true;
        }

        for (Node n : current.nodes) {
            if ( n.visited == false ) {
                isAccessible(n, end, found);
            }
        }
    }

    public static void main(String args[]) {
        Ch04Ex02 ch04Ex02 = new Ch04Ex02();
        ch04Ex02.runMe();
    }
}
