package com.bao.doan.example;
import java.util.Arrays;
/*Implement function countNumbers that accepts a sorted array of integers and counts the number of array elements that are less than the parameter lessThan.

For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.*/
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int result = Arrays.binarySearch(sortedArray, lessThan);
        if (result <0){
            result = - (result +1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}