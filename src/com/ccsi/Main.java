package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    TreeNode tree1=buildTree1();
        TreeNode tree2=buildTree2();
        System.out.println(isSameTree2(tree1,tree2));
    }
    //Given two binary trees,writes a function to check if they are equal or not
    //1.recursion
    public static boolean isSameTree1(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        else{
            if(p.val!=q.val)return false;
            else{
                return isSameTree1(p.left,q.left)&&isSameTree1(p.right,q.right);
            }
        }
    }
    //2.loop
    public static boolean isSameTree2(TreeNode p,TreeNode q){
        //if(p==null&&q==null)return true;
        //if(p==null||q==null)return false;
        Queue<TreeNode> queuep=new LinkedList<>();
        Queue<TreeNode> queueq=new LinkedList<>();
        queuep.offer(p);
        queueq.offer(q);
        while(!queuep.isEmpty()&&!queueq.isEmpty()){
            TreeNode tempp=queuep.poll();
            TreeNode tempq=queueq.poll();
            if(tempp==null&&tempq==null)return true;
            if(tempp==null||tempq==null)return false;
            else{
                if(tempp.val!=tempq.val)return false;
                else{
                    queuep.offer(tempp.left);
                    queuep.offer(tempp.right);
                    queueq.offer(tempq.left);
                    queueq.offer(tempq.right);
                }
            }
        }
        return true;
    }
    public static TreeNode buildTree1(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        return root;
    }

    public static TreeNode buildTree2(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}