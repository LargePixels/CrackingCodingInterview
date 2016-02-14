package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.generic.Node;

/**
 * Created by johnminchuk on 2/13/16.
 */
public class Ch02Ex06 {

    private void runMe() {
        Node<Integer> head = Node.listFromArray(new Integer[]{1,2,3,4,5,6,7,8,9});
        Node.loopIt(head, 4);

        findLoopStart(head);
    }

    private void findLoopStart(Node<Integer> head) {
        Node slow = head;
        Node fast = head;

        while ( fast != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) {
                break;
            }
        }

        fast = head;
        while ( fast != slow ) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("Loop starts at node:" + slow.value);
        return;
    }

    public static void main(String args[]) {
        Ch02Ex06 ch02Ex06 = new Ch02Ex06();
        ch02Ex06.runMe();
    }

}
