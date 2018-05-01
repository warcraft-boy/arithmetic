package com.Jevin.chapter01;

/**
 * 这里介绍一下冒泡和选择排序：
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr={12,1,23,6,78,36,17,12};
        //int[] array=test01(arr);
        int[] array=test02(arr);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
    }

    //冒泡排序：从小到大
    public static int[] test01(int[] arr){
        /**
         * 外层循环表示要排序的轮数，每一轮选出一个最大数，最后只剩一个数不许比较，所以是i<=arr.length-1
         * 那么这里为什么不写成i<arr.length呢，写成i<=arr.length-1更能体现它的数学思想，便于思考；
         */
        for(int i=1;i<=arr.length-1;i++){
            /**
             * 内层循环表示每一轮要比较的次数,j这里承担了两个角色，第一，作为数的索引；第二，每一轮要比较的次数；
             * 每一轮比较的次数应该是arr.length-i(即为，每一轮循环选出了一个最大数，下一轮这个最大数不需要再参与比较，
             * 所以要减i);但是下面if(){}语句arr[j+1],j多取到了索引后一位，所以需要再减去1；
             */
            for(int j=0;j<=arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }



    //选择排序：从小到大
    public static int[] test02(int[] arr){
        /**
         * 外层循环表示要比较的轮数，同冒泡排序；
         */
        for(int i=1;i<=arr.length-1;i++){
            /**
             * 这里设置了一个索引index,它表示一个指针，存储在此索引中的数默认是从小到大的；
             */
            int index=i-1;
            /**
             * 内层循环表示每一轮要比较的次数，假设index中存储的是最小数，那么将index后的每一个数
             * 与之比较，如若小于它，则交换索引，这样保证index中始终存储的是相对最小数；
             */
            for(int j=i;j<=arr.length-1;j++){
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            //将存储在index索引中的最小数重新放到它原来的位置上；
            int temp=arr[i-1];
            arr[i-1]=arr[index];
            arr[index]=temp;
        }
        return arr;
    }
}
