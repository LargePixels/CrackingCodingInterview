package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.generic.Node;

/**
 * Created by johnminchuk on 2/10/16.
 */
public class Ch02Ex05 {

    private void runMe() {

        //
        //  first attempt, didn't read the question right...  could have made this work though, a method to add it up, another to tally those together
        //
        Node head1 = Node.listFromArray(new Integer[]{4, 3, 2, 1});
        Node.printList(head1);
        System.out.println("The value of this list is: " + listSum(head1));

        Node head2 = Node.listFromArray(new Integer[]{1, 2, 3, 4});
        Node.printList(head2);
        System.out.println("The value of this if written backwards is: " + listSumBackwards(head2));

        //
        // but lets use that attempt after all, since now we read it all the way through
        //
        System.out.println("The value of these lists added together is: " + addListsJm(head1, head2));

        //
        //  the example from the book so i can see wtf we're talking about here
        //
        Node l1 = Node.listFromArray(new Integer[]{3, 2, 1});
        Node l2 = Node.listFromArray(new Integer[]{0, 0, 1});
        Node asdf = addLists(l1, l2, 0);
        System.out.println("Values added together recursively: ");
        Node.printList(asdf);

        //
        //  my attempt to do the same in iterative way
        //
        Node qwer = addNodesIter(l1, l2);
        System.out.println("Values added the same way but iterative: ");
        Node.printList(qwer);

    }

    public int addListsJm(Node n1, Node n2) {
        int v1 = listSum(n1);
        int v2 = listSum(n2);
        return v1 + v2;
    }

    public Node addNodesIter(Node n1, Node n2) {
        Node rtn = null;
        Node end = null;
        int carry = 0;
        while ( n1 != null && n2 != null && carry == 0) {
            int v1 = n1 != null ? (int) n1.value : 0;
            int v2 = n2 != null ? (int) n2.value : 0;

            int sum = v1 + v2 + carry;

            if ( sum >= 10 ) {
                sum = sum %10;
                carry = 1;
            }
            else {
                carry = 0;
            }

            if (rtn == null) {
                rtn = new Node(sum);
                end = rtn;
            }
            else {
                end.next = new Node(sum);
                end = end.next;
            }

            n1 = n1.next != null ? n1.next : null;
            n2 = n2.next != null ? n2.next : null;
        }

        return rtn;
    }

    public Node addLists(Node n1, Node n2, int carry) {

        if ( n1 == null && n2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(carry);

        int value = carry;
        if (n1 != null) {
            value += (int) n1.getValue();
        }
        if (n2 != null) {
            value += (int) n2.getValue();
        }

        result.value = value % 10;

        if ( n1 != null || n2 != null ) {
            Node more = addLists(
                    n1 == null ? null : n1.next,
                    n2 == null ? null : n2.next,
                    value >= 10 ? 1: 0
            );
            result.next = more;
        }

        return result;
    }

    private int listSum(Node head) {
        int sum = 0;
        int i = 0;
        while (head != null) {
            sum += ((Integer) head.value) * Math.pow(10, i);
            i++;
            head = head.next;
        }

        return sum;
    }

    private int listSumBackwards(Node head) {
        int sum = 0;

        int i = -1;
        Node runner =  head;
        while ( runner != null ) {
            runner = runner.next;
            i++;
        }

        while (head != null) {
            sum += ((Integer) head.value) * Math.pow(10, i);
            i--;
            head = head.next;
        }

        return sum;
    }

    public static void main(String args[]) {
        Ch02Ex05 ch02Ex05 = new Ch02Ex05();
        ch02Ex05.runMe();
    }
}
