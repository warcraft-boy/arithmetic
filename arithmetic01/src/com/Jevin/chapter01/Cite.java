package com.Jevin.chapter01;

import java.util.Arrays;

/**
 * 这里要解决的问题是：
 *                     假设一组N个数，要确定其中的第k个最大数：
 */
public class Cite {
    public static void main(String[] args){

        int[] arr=new int[]{9,4,14,25,98,47};

        //test01()使用冒泡排序法求出第三个最大数：
        /*int value01=test01(arr,3);
        System.out.println(value01);*/ //k=3，即第三个最大数，为25

        //test02()使用选择排序法求出第三个最大数：
        /*int value02=test02(arr,3);
        System.out.println(value02);*/

        //test03()思路二：
        int value03=test03(arr,3);
        System.out.println(value03);

        /**
         * 可以看到思路二的循环次数明显少于思路一的冒泡和选择排序，因此思路二在处理大量数据的效率上要优于思路一；
         */
    }

    /**
     * 思路一：将这N个数按照冒泡或者选择排序法从大到小排列，找到第k个数，即为所得；
     */
    //方法一：这里使用冒泡排序法：
    public static int test01(int[] arr,int k){
        for(int i=1;i<=arr.length-1;i++){
            for(int j=0;j<=arr.length-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr[k-1];
    }

    //方法二：这里使用选择排序法：
    public static int test02(int[] arr,int k){
        for(int i=1;i<=arr.length-1;i++){
            int index=i-1;
            for(int j=i;j<=arr.length-1;j++){
                if(arr[index]<arr[j]){
                    index=j;
                }
            }
            int temp=arr[i-1];
            arr[i-1]=arr[index];
            arr[index]=temp;
        }
        return arr[k-1];
    }


    /**
     *思路二：1.将此数组arr中的前k个元素取出来组成一个新的数组brr，并从大到小排序;
     *        2.剩下的元素逐个录入，如果小于第k个元素，则忽略；如果大于，则将其放入到数组brr中的相应的位置，
     *        此时数组brr会多出一个元素k+1，舍掉，以此循环往复到最后一个元素即可得到最后的brr，且brr第k个元素即为arr的第k个最大者；
     */

    public static int test03(int[] arr,int k){
        int[] brr=Arrays.copyOfRange(arr,0,k);
        brr=arraySort(brr);
        //for(){}循环表示数组arr被截取后的元素逐个录入：
        for(int i=brr.length;i<arr.length;i++){
            if(brr[brr.length-1]>arr[i]){
                //如果arr剩下的元素都小于crr的第k个元素，则crr中的最后一个元素即为arr中的第k个最大者：
                continue;   //结束当前循环，进行下一次循环；注意这里千万不要用break或者是return,要不然结束直接跳出循环体了；
            }else{
                //只要arr剩下的元素出现一个比crr中的元素中的大者，则crr加上这个元素重新排序，并踢出最小的那个：
                brr=Arrays.copyOf(brr,brr.length+1);
                brr[brr.length-1]=arr[i];
                brr=arraySort(brr);
                brr=Arrays.copyOfRange(brr,0,brr.length-1);
                continue;
            }
        }
        return brr[brr.length-1];
    }

    //这里进行数组排序，方便其他方法的调用：
    public static int[] arraySort(int[] arr){
        for(int i=1;i<=arr.length-1;i++){
            for(int j=0;j<=arr.length-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
