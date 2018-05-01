package com.Jevin.test;

import java.util.Arrays;

public class Test02 {
    public static void main(String[] args){
        //Arrays.copyOf(int[] original,int newLength)数组拷贝，增加数组的长度：
        int[] arr=new int[]{9,4,6,12,54};
        int[] brr=Arrays.copyOf(arr,arr.length+1);
        brr[brr.length-1]=666;
        for(int i:brr){
            System.out.print(i+"\t");
        }
    }
}
