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
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
        ListNode nextt = head.next;
        head.next=prev;
        prev= head;
        head= nextt;
    }
    return prev;
    }
    private ListNode clone(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head!=null){
            ListNode next =new ListNode(head.val);
            temp.next = next;
            head= head.next;
            temp=temp.next; 
        }
        return dummy.next;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode headA = reverse(clone(head));
        while(headA!=null){
            if(headA.val!=head.val)return false;
            headA=headA.next;
            head=head.next;
        } 
        return true;
        
    }
}