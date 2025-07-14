/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int decimalvalue = 0;
        ListNode curr = head;
        while(curr != null){
            decimalvalue = (decimalvalue << 1) | curr.val;
            curr = curr.next;
        }
        return decimalvalue;
    }
}
