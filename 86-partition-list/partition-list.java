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
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(0);
        ListNode higher = new ListNode(0);
        ListNode low = lesser,high = higher;
        while(head!=null){
            if(head.val<x){
                low.next=head;
                low=low.next;
            }
            else{
                high.next=head;
                high=high.next;
            }
            head=head.next;
        }
           high.next = null;
           low.next = higher.next;
        return lesser.next;
    }
}