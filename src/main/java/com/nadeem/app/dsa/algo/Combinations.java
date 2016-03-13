package com.nadeem.app.dsa.algo;

import java.util.Arrays;

public class Combinations {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,  5};
        int r = 3;
        Arrays.sort(arr);
        combine(arr, r);
    }

    private static void combine(int[] arr, int r) {
        int[] res = new int[r];
        doCombine(arr, res, 0, 0, r);
    }

    private static void doCombine(int[] arr, int[] res, int currIndex, int level, int r) {
        if(level == r){
            printArray(res);
            return;
        }
        for (int i = currIndex; i < arr.length; i++) {
            res[level] = arr[i];
            doCombine(arr, res, i+1, level+1, r);
            //way to avoid printing duplicates
            if(i < arr.length-1 && arr[i] == arr[i+1]){
                i++;
            }
        }
    }

    private static void printArray(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
