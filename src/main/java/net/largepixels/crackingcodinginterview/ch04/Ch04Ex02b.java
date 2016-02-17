package net.largepixels.crackingcodinginterview.ch04;

import net.largepixels.interviewstructures.nodes.graph.statenode.Graph;
import net.largepixels.interviewstructures.nodes.graph.statenode.Node;
import net.largepixels.interviewstructures.nodes.graph.statenode.State;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by johnminchuk on 2/16/16.
 */
public class Ch04Ex02b {

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

        Graph graph = new Graph();
        graph.nodes.addAll(Arrays.asList(a,b,c,d,e));

        boolean accessible = search(graph, b, d);
        System.out.println("Can b reach d? " + accessible);
    }


    public static boolean search(Graph g, Node start, Node end) {
        Queue<Node> q = new ArrayBlockingQueue<>(20);

        for ( Node u : g.nodes ) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;

        while ( !q.isEmpty() ) {
            u = q.remove();
            if ( u != null ) {
                for (Node v : u.nodes ) {
                    if (v.state == State.Unvisited ) {
                        if (v == end) {
                            return true;
                        }
                        else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Ch04Ex02b ch04Ex02 = new Ch04Ex02b();
        ch04Ex02.runMe();
    }
}
