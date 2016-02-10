package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.generic.Node;

/**
 * Created by johnminchuk on 2/10/16.
 */
public class Ch02Ex05 {

    private void runMe() {
        Node head1 = Node.listFromArray(new Integer[]{4, 3, 2, 1});
        Node.printList(head1);
        System.out.println("The value of this list is: " + listSum(head1));

        Node head2 = Node.listFromArray(new Integer[]{1, 2, 3, 4});
        Node.printList(head2);
        System.out.println("The value of this list is: " + listSumBackwards(head2));

        Node l1 = Node.listFromArray(new Integer[]{3, 2, 1});
        Node l2 = Node.listFromArray(new Integer[]{0, 0, 1});

        Node asdf = addLists(l1, l2, 0);

        Node.printList(asdf);
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
