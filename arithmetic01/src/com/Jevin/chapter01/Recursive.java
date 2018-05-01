package com.Jevin.chapter01;

/**
 * 递归：
 */
public class Recursive {
    public static void main(String[] args){

        System.out.println(function(3));
    }


    /**
     * 当一个函数用他自己来定义时就成为递归；
     * 例如：在非负整数集上定义一个函数f,它满足f(0)=0,且f(x)=2f(x-1)+x*x;
     */
    public static int function(int x){
        if(x==0){
            return 0;
        }
        return 2*function(x-1)+x*x;
    }
}
