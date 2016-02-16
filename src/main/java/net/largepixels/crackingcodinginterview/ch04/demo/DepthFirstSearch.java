package net.largepixels.crackingcodinginterview.ch04.demo;

import net.largepixels.interviewstructures.nodes.graph.Node;

/**
 * Created by johnminchuk on 2/16/16.
 */
public class DepthFirstSearch {

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

        depthFirstSearch(d);
    }

    private void depthFirstSearch(Node head) {
        if ( head.visited ) {
            return;
        }

        System.out.println("Visting: " + head.value);
        head.visited = true;

        for (Node node : head.nodes) {
            depthFirstSearch(node);
        }
    }

    public static void main(String args[]) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.runMe();
    }

}
