package com.study.utill;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/21.
 */
public class QuickSort {
    public static void quickSort(int arr[],int start,int end){
        if (start >= end){
            return ;
        }
        int i = start;
        int j = end;
        int index = arr[start];

        while(i<j){
            while (i<j&&arr[j]>index){
                j--;
            }
            if (i<j){
                arr[i] = arr[j];
                i++;
            }
            while (i<j&&arr[i]<index){
                i++;
            }
            if (i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=index;
       // if(i>start)
        quickSort(arr,start,i-1);
       // if (end>j)
        quickSort(arr,j+1,end);
    }
    public static void main(String args[]){
        int arr[] = {7,2,8,4,9,1,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void qc(int arr[],int start,int end){
        if(start >= end){
            System.out.println("exit");
            return;}
        int i =start;
        int j = end;
        int index = arr[start];
        while(i<j){
            while (i<j&&arr[j]>index){
                j--;
            }
            if (i<j){
                arr[i] = arr[j];
                i++;
            }
            while (i<j&&arr[i]<index){
                i++;
            }
            if (i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=index;
        /*if (start<i){
            qc(arr,start,i-1);

        }

        if (end>j){
            qc(arr,j+1,end);
        }*/
        qc(arr,start,i-1);
        qc(arr,j+1,end);
    }
}
