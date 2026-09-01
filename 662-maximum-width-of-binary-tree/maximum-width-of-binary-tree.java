/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode root;
        int index;
        Pair(TreeNode root,int index){
            this.root = root;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int max = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            long start = q.peek().index;
            long end = start;
            int size = q.size();
            for(int i =0;i<size;i++){
                Pair curr = q.poll();
                end = curr.index;
            if(curr.root.left!=null){
                q.offer(new Pair(curr.root.left,2*curr.index+1));
            }
            if(curr.root.right!=null){
                q.offer(new Pair(curr.root.right,2*curr.index+2));
            }
        }
        max = Math.max(max,(int)(end-start+1));
        }
        return max;
    }
}