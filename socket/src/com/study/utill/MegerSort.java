package com.study.utill;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/21.
 */
public class MegerSort {
    public static void megerSort(int[] arr,int start,int len){
        int size = arr.length;
        int mid = size/(len<<1);
        if (mid == 0)return ;
        int c = size&((len<<1)-1);
        for(int i=0;i<mid;i++){
            start = i*2*len;
            meger(arr,start,start+len,start+2*len-1);
        }
        if (c!=0){
            meger(arr,size-c-2*len,size-c,size-1);
        }
        megerSort(arr,0,2*len);
    }

    private static void meger(int[] arr, int s,int len, int m) {
        int[] temp = new int[m-s+1];
        int i = s,j=len,k=0;
        while (i<len&&j<=m){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                k++;
                i++;
            }else {
                temp[k]=arr[j];
                k++;
                j++;
            }
        }
        while (i<len){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while (j<=m){
            temp[k]=arr[j];
            j++;
            k++;
        }
        System.arraycopy(temp,0,arr,s,temp.length);

    }
    public static void main(String args[]){
        int arr[]={4,2,5,1,3,8,0,9};
       megerSort(arr,0,1);
        //gb(arr,0,1);
        System.out.println(Arrays.toString(arr));
    }

}