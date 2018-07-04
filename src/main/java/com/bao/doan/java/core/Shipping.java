package com.bao.doan.java.core;

public class Shipping {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        if(items > (availableLargePackages * 5 + availableSmallPackages)) {
        	return -1;
        } 
       int min = 0;
       for (int i = 1 ;i <= availableLargePackages; i ++)
    	   for(int j = 1; j<= availableSmallPackages; j++) {
    		   if(i*5 +j == items) {
    			   min = i +j;
    			   return min;
    		   }
    	   }
       return min;
    }
    
    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 7));
    }
}