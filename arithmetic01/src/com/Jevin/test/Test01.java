package com.Jevin.test;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args){
        //这里测试Arrays工具类中的copyOfRange(int[] original,int from,int to)方法,返回一个该数组的子数组,该方法为静态方法；
        int[] arr=new int[]{1,6,9,45,2,66,41,25,12,32};
        //加入我要拷贝这个元素的前3个元素组成一个新的数组：
        int[] brr=Arrays.copyOfRange(arr,0,3); //注意这里不包括3
        for(int i:brr){
            System.out.print(i+"\t");
        }

    }
}
