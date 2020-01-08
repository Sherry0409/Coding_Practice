import java.util.Arrays;

public class AAmergeSort {

    public static void mergeSort(int[] arr, int l, int r){
        //首先判断异常情况，如果数组数量为0/1则不用排序
        if (arr.length < 2 || arr == null){
            return;
        }

        if (l == r){
            return;
        }

        int mid = l + ((r - l) >> 1);

        //不返回值相对简略
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, r, mid);

        return ;
    }

    public static void merge (int[] arr, int l, int r, int mid){
        if (l == r){
            return;
        }


        int p1 = l;
        int p2 = mid + 1;
        int[] help = new int[arr.length];
        int i = 0;

        while (p1 < mid+1 && p2 < r+1){

            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 < mid+1){
            help[i++] = arr[p1++];
        }

        while (p2 < r+1){
            help[i++] = arr[p2++];
        }

        // 只能copy复制的部分
        for (int m = l; m <=r; m++){
            arr[m] = help[m-l];
        }

        return;


    }


    public static void main(String[] args) {
        int[] array = new int[]{2,4,16};
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
