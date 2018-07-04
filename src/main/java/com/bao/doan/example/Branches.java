package com.bao.doan.example;

 
import java.util.HashSet; 
public class Branches {
	public static int count(int[] tree) {
        if(tree.length == 1){
            return 1;
        }
    	HashSet<Integer> parent = new HashSet<Integer>();
    	 
        for (int i = 0; i< tree.length; i ++) {
        	if(tree[i] >0){
        	   parent.add(tree[i]);
            }
        }  
        return parent.size();
    }

    public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, -1, 1 }));
    }
}