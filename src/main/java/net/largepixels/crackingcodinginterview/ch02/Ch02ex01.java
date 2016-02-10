package net.largepixels.crackingcodinginterview.ch02;

import net.largepixels.crackingcodinginterview.common.Node;
import net.largepixels.crackingcodinginterview.common.NodeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by johnminchuk on 2/9/16.
 */
public class Ch02ex01 {

    private void runMe() {

        System.out.println("Remove with a buffer...");

        Node head = NodeUtils.singlyDupedList();
        NodeUtils.printList(head);
        removeDuplicates(head);
        NodeUtils.printList(head);

        System.out.println("Now remove without buff...");

        head = NodeUtils.singlyDupedList();
        NodeUtils.printList(head);
        removeDuplicatesNoBuff(head);
        NodeUtils.printList(head);
    }

    private void removeDuplicates(Node head) {
        Set<String> dupes = new HashSet();

        Node current = head;
        Node previous = head;
        while (current != null) {
            if ( dupes.contains(current.value) ) {
                previous.next = current.next;
            }
            else {
                dupes.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    private void removeDuplicatesNoBuff(Node head) {
        Node current = head;
        while ( current != null ) {
            Node runner = current.next;
            Node runnerPrev = current;
            while (runner != null) {
                if (runner.value == current.value) {
                    runnerPrev.next = runner.next;
                }
                else {
                    runnerPrev = runnerPrev.next;
                }
                runner = runner.next;
            }

            current = current.next;
        }

    }

    public static void main(String args[]) {
        Ch02ex01 ch02ex01 = new Ch02ex01();
        ch02ex01.runMe();
    }

}
