package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.generic.Node;

import java.util.Stack;

/**
 * Created by johnminchuk on 2/15/16.
 */
public class Ch02Ex07 {

    private void runMe() {
        Node head1 = Node.listFromArray(new Character[] {'a', 'b', 'b', 'a'});
        Node.printList(head1);
        System.out.println("Is it a palendrome? " + isLlPalendrome(head1));

        Node head2 = Node.listFromArray(new Character[] {'a', 'b', 'c', 'b', 'a'});
        Node.printList(head2);
        System.out.println("Is it a palendrome? " + isLlPalendrome(head2));

        Node head3 = Node.listFromArray(new Character[] {'a', 'b', 'c', 'a'});
        Node.printList(head3);
        System.out.println("Is it a palendrome? " + isLlPalendrome(head3));
    }

    private boolean isLlPalendrome(Node head) {
        Node current = head;

        Stack<Character> stack = new Stack<>();

        int count = 0;
        while ( current != null ) {
            count++;
            stack.push( (Character)current.value );
            current = current.next;
        }

        int half = count / 2;
        int count2 = 1;
        current = head;

        if ( count % 2 != 0 ) {
            half++;
        }

        while ( current != null ) {
            if ( count2 <= half ) {
                stack.pop();
            }
            else {
                if ( current.value != stack.pop() ) {
                    return false;
                }
            }
            count2++;
            current = current.next;
        }

        return true;
    }

    public static void main(String args[]) {
        Ch02Ex07 ch02Ex07 = new Ch02Ex07();
        ch02Ex07.runMe();
    }
}
