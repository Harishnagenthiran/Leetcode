class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return travel(
            preorder, 0, preorder.length - 1,
            inorder, 0, inorder.length - 1,
            map
        );
    }

    private TreeNode travel(
            int[] preorder, int prest, int preend,
            int[] inorder, int inst, int inend,
            Map<Integer, Integer> map) {

        if (prest > preend || inst > inend) {
            return null;
        }

        // First element of preorder is the root
        TreeNode root = new TreeNode(preorder[prest]);

        // Find root position in inorder
        int inCurr = map.get(root.val);

        // Number of nodes in left subtree
        int len = inCurr - inst;

        // Build left subtree
        root.left = travel(
            preorder, prest + 1, prest + len,
            inorder, inst, inCurr - 1,
            map
        );

        // Build right subtree
        root.right = travel(
            preorder, prest + len + 1, preend,
            inorder, inCurr + 1, inend,
            map
        );

        return root;
    }
}