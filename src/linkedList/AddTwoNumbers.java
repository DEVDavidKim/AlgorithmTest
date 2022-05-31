package src.linkedList;


import src.util.ListNode;

import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        //AddTwoNumbers sol = new AddTwoNumbers();
        //print(l1);
        AddTwoNumbers a = new AddTwoNumbers();
        print(a.addTwoNo(l1,l2));

    }

    private static void print(ListNode solve) {

        while(solve != null){
            System.out.println(solve.val);
            solve = solve.next;
        }
    }

    private ListNode addTwoNo(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);

        ListNode nd1 = l1;
        ListNode nd2 = l2;
        ListNode nd3 = l3;

        int carry = 0;

        while (nd1 != null || nd2 != null){

            if(nd1 != null){
                carry += nd1.val;
                nd1 = nd1.next;
            }

            if(nd2 != null){
                carry += nd2.val;
                nd2 = nd2.next;
            }

            nd3.next = new ListNode(carry%10);
            nd3 = nd3.next;
            carry = carry/10;

        }

        if(carry>0){
            nd3.next = new ListNode(carry);
        }

        return l3.next;
    }

}
