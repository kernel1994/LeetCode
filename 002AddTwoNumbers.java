/**
* time: 2016-07-31 23:00:00
* note: The code is redundancy and ugly.
*/

/**
* You are given two linked lists representing two non-negative numbers. 
* The digits are stored in reverse order and each of their nodes contain a single digit. 
* Add the two numbers and return it as a linked list.
*
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        ln.next = null;
        // due to the digits are stored in reverse order, we need append node at the last of list.
        // so, we need something to record the last one.
        ListNode lnLast = ln;
        
        int flag = 0;
        
        while (l1 != null || l2 != null) {
            flag++;
            
            int sum = l1.val + l2.val;
            int carry = 0;
            
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
                
                if (l1.next != null) {
                    l1.next.val += carry;
                } else if (l2.next != null) {
                    l2.next.val += carry;
                }
            }
            
            if (flag == 1) {
                ln.val = sum;
                
                lnLast = ln;
            } else {
                ListNode lnTemp = new ListNode(sum);
                lnTemp.next = null;
                
                lnLast.next = lnTemp;
                lnLast = lnTemp;
            }
            
            // if the last two number added will carry, add a new node to the last of list
            if (carry == 1 && l1.next == null && l2.next == null) {
                ListNode lnTemp = new ListNode(carry);
                lnTemp.next = null;
                
                lnLast.next = lnTemp;
                
                return ln;
            }
            
            if (l1.next == null && l2.next != null) {
                lnLast.next = l2.next;
                
                while (l2.next.val >= 10) {
                    ListNode l2Next = l2.next;
                    
                    l2Next.val = l2Next.val - 10;
                    
                    if (l2Next.next == null) {
                        ListNode lnTemp = new ListNode(1);
                        lnTemp.next = null;
                
                        l2Next.next = lnTemp;
                        
                        return ln;
                    } else {
                        l2Next.next.val += 1;
                    }
                    
                    l2 = l2.next;
                }
                
                return ln;
            }
            
            if (l1.next != null && l2.next == null) {
                lnLast.next = l1.next;
                
                while (l1.next.val >= 10) {
                    ListNode l1Next = l1.next;
                    
                    l1Next.val = l1Next.val - 10;
                    
                    if (l1Next.next == null) {
                        ListNode lnTemp = new ListNode(1);
                        lnTemp.next = null;
                
                        l1Next.next = lnTemp;
                        
                        return ln;
                    } else {
                        l1Next.next.val += 1;
                    }
                    
                    l1 = l1.next;
                }
                
                return ln;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return ln;
    }
}
