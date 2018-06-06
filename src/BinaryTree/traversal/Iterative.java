package com.ds.BinaryTree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Iterative {

    private Node root;

    private void preOrder() {

        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        Node top; // This will updated by pop to walk down the tree.
        stack.push(root);

        while(!stack.isEmpty()) {

            top = stack.pop();
            System.out.println(top.data);

            if(top.right != null)
                stack.push(top.right);

            if(top.left != null)
                stack.push(top.left);
        }

    }


    // https://www.youtube.com/watch?v=nzmtCFNae9k
    private void inOrder() {

        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();

        while(true) {

            // Strategy: keep on pushing all the left elements first starting from root
            if(root!=null) {
                stack.push(root);
                root = root.left;
            } else {  // Strategy: After pushing all elements, pop and print data (ONE leftmost and root), then make root as right.

                if(stack.isEmpty())
                    break;
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }

    // Strategy:
    // Use 2 stacks, first put in stack1, pop from stack1 and put in Stack2
    // In Stack2 check if left or right exists, then push in stack1
    // At the end, stack1 will be empty and stack2 will have all the elements in order
    // https://www.youtube.com/watch?v=qT65HltK2uE
    private void postOrder() {

        if(root==null)
            return;

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        stack1.push(root);

        while(!stack1.empty()) {

            stack2.push(stack1.pop());

            if(stack2.peek().left != null) // We don't want to remove elements from stack2, just peek
                stack1.push(stack2.peek().left);

            if(stack2.peek().right != null)
                stack1.push(stack2.peek().right);

        }

        while(!stack2.empty()) {
            System.out.println(stack2.pop().data);
        }

    }

    private void levelOrder(Node root) {

        if (root == null) {
            throw new IllegalStateException("Invalid");
        }

        Queue<Node> queue = new LinkedList<>();
        Node node = root;

        queue.offer(node);

        while (!queue.isEmpty()) {

            node = queue.poll();
            System.out.println(node.data);

            if(node.left!=null) {
                queue.add(node.left);
            }

            if(node.right!=null) {
                queue.add(node.right);
            }

        }

    }



    public static void main(String args[]) {

        Iterative tree = new Iterative();
        tree.root = new Node(3);
        tree.root.left = new Node(1);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.right = new Node(0);
        tree.root.left.right = new Node(5);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(3);
//        tree.levelOrder(tree.root);
        tree.preOrder();

    }

    public static class Node {

        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
