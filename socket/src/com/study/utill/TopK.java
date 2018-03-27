package com.study.utill;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/21.
 */
public class TopK {
    public static int  qc(int arr[],int start,int end){
        if (start >= end){
            return -1;
        }
        int i = start;
        int j = end;
        int index = arr[start];
        while (i<j){
            while (i<j && arr[j]<index) j--;
            if (i<j){
                arr[i] = arr[j];
                i++;
            }
            while (i<j&&arr[i]>index) i++;
            if (i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i] = index;
        return i;
    }

    public static int topK(int[] arr,int start,int end,int k){
        if(start>end || k<1)
            return -1;
        if(end == start){
            return arr[end];
        }
        int index = qc(arr,start,end);
        if ((index+1)==(start+k)){
            return arr[index];
        }else {
            if ((index+1)>(start+k)){
               return topK(arr,start,index-1,k);
            }else {
               return topK(arr,index+1,end,k+start-index-1);
            }
        }
    }
    public static void main(String args[]){
        int arr[]={4,2,9,5,8,7,3,1,2,2};
        //int a = qc(arr,0,arr.length-1);

        int a = topK(arr,0,arr.length-1,6);
        System.out.println(a);
        System.out.println(Arrays.toString(arr));
    }

}
