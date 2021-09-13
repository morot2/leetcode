package java_sol.easy;

import java_sol.comm.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinarySearchInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        Stack<TreeNode> route = new Stack();
        addTraversalRoute(route, root);

        List<Integer> res = new LinkedList<>();
        while(!route.isEmpty()){
            TreeNode current = route.pop();

            res.add(current.val);

            if(current.right != null)
                addTraversalRoute(route, current.right);
        }

        return res;
    }

    private static void addTraversalRoute(Stack<TreeNode> route, TreeNode current){
        while(current != null){
            route.push(current);
            current = current.left;
        }
    }

    public static void main(String[] args){
        TreeNode end = new TreeNode(3);
        TreeNode medium = new TreeNode(2, end, null);
        TreeNode root = new TreeNode(1, null, medium);

        inorderTraversal(root);
    }
}
