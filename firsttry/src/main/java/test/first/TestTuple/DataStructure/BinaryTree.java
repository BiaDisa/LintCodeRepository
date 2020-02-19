package test.first.TestTuple.DataStructure;



import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


public class BinaryTree {

    static class TreeNode{
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
            this.val = val;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getHeight(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        queue.add(head);
        int height = 0;
        int lastNum = 0;
        do {
            while (!queue.isEmpty()) {
                TreeNode wrk = queue.poll();
                if (wrk.leftChild != null) {
                    nextQueue.add(wrk.leftChild);
                }
                if (wrk.rightChild != null) {
                    nextQueue.add(wrk.rightChild);
                }
            }
            height++;
            queue = nextQueue;
            nextQueue = new LinkedList<>();
        }while(!queue.isEmpty());
        return height;
    }

    public static void main(String[] args){
        TreeNode head = new TreeNode(1);
        TreeNode node0 = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        head.leftChild = node0;
        node0.leftChild = node1;
        node0.rightChild = node2;
        System.out.println(getHeight(head));
    }
}
