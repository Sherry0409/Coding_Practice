// 小和问题
//一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和，求一个数组的小和

import java.util.ArrayList;
import java.util.Arrays;

public class ABlittleSum {
    int littleSum = 0;
    public void mergeSort(int[] arr, int l, int r){
        if (arr == null || arr.length < 2){
            return;
        }

        //迭代终止条件必须要有，和上面判断arr是否为空情况不同
        if (l==r){
            return;
        }

        //get mid number
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, r, mid);
    }

    public void merge(int[] arr, int l, int r, int mid){
        if (l == r){
            return;
        }

        int p1 = l;
        int p2 = mid + 1;
        int[] help = new int[arr.length];
        int i = 0;

        while (p1 < mid + 1 && p2 < r + 1){
            if (arr[p1] < arr[p2]) {
                help[i++] = arr[p1];
                littleSum = littleSum + arr[p1++]*(r-p2+1);
//                System.out.println(littleSum);
            }
            else {
                help[i++] = arr[p2++];
            }
        }

        while (p1 < mid+1){
            help [i++] = arr[p1++];
        }

        while (p2 < r + 1){
            help[i++] = arr[p2++];
        }

        for (int n = l; n < r+1; n++){
            arr[n] = help[n-l];

        }
    }

    public static void main(String[] args){
        ABlittleSum ls = new ABlittleSum();
        int[] arr = new int[]{1,3,4,2,5};
        ls.mergeSort(arr, 0, arr.length - 1);
        System.out.println(ls.littleSum);
        System.out.println(Arrays.toString(arr));
    }
}
