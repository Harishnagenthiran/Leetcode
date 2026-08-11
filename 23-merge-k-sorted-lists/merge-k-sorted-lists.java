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
    private ListNode merge (ListNode a,ListNode b){
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        while(a!=null&&b!=null){
            if(a.val<b.val){
                res.next = a;
                a= a.next;
            }
            else{
                res.next = b;
                b =b.next;
            }
            res=res.next;
        }
            res.next=(a!=null)?a:b;
              return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        for(int i =1;i<k;i++){
            lists[0]=merge(lists[0],lists[i]);
        }
        return k ==0?null: lists[0];
        
    }
}