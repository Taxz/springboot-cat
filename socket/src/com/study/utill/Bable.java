package com.study.utill;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/21.
 */
public class Bable {
    public static void b(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
               if (arr[j]>arr[j+1]){
                   int tem = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = tem;
               }
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {1,3,2,5,9,6,4};
        b(arr);
        System.out.println(Arrays.toString(arr));
    }
}
