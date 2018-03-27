package com.study.utill;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/21.
 */
public class SelectSort {
    public static void selectSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min = arr[i];
            int index = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<min){
                    min = arr[j];
                    index =j;
                }
            }
            if(index != i){
                arr[index] = arr[i];
                arr[i] = min;

            }
        }
    }
    public static void main(String []args){
        int arr[] = {8,3,5,2,6,4,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
