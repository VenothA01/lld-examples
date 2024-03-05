//package com.dailycoder.LeetCodeHard;
//
//class Node{
//
//    int data;
//    Node left;
//    Node right;
//
//    public Node(int data){
//        this.data = data;
//    }
//}
//
//public class BST {
//
//
//    Node root = null;
//
//    public void insert(int data){
//        Node newNode = new Node(data);
//
//        if(root==null){
//            root = newNode;
//            return;
//        }
//        Node curr = root;
//        Node parent = null;
//
//        while (true){
//            parent = curr;
//            if(data < parent.data){
//                curr = curr.left;
//                if( curr==null){
//                    parent.left = newNode;
//                    return;
//                }
//            }
//            else {
//                curr = curr.right;
//                if (curr==null){
//                    parent.right=newNode;
//                    return;
//                }
//            }
//        }
//    }
//
//    public Node minNode(Node root){
//
//        if(root.left!=null)
//            return minNode(root.left);
//        else
//            return root;
//    }
//
//    public Node maxNode(Node root){
//
//        if(root.left!=null)
//            return maxNode(root.right);
//        else
//            return root;
//    }
//
//    public Node kthMaxNode(Node root,int index,int k){
//
//        if(root.left!=null && k>0){
//            k--;
//            return kthMaxNode(root.right,k);
//        }
//        else{
//            return root;
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//        BST bst = new BST();
//        bst.insert(50);
//        bst.insert(30);
//        bst.insert(70);
//        bst.insert(60);
//        bst.insert(10);
//        bst.insert(90);
//
//        System.out.println(bst.minNode(bst.root).data);
//        System.out.println(bst.maxNode(bst.root).data);
//        System.out.println(bst.kthMaxNode(bst.root,1).data);
//
//    }
//}
