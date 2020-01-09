import java.util.Arrays;

public class ACreverseCouple {
    public static void mergeSort(int[] arr, int l, int r){
        if (arr == null || arr.length <2){
            return;
        }

        if (l == r){
            return;
        }

        int mid = l + ((r-l) >> 1);
        mergeSort(arr, l ,mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, r, mid);
    }

    public static void merge(int[] arr, int l, int r, int mid){
        if (l == r){
            return;
        }

        int p1 = l;
        int p2 = mid+1;
        int[] help = new int[arr.length];
        int i = 0;

        while (p1 < mid+1 && p2 < r+1){
            if (arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            }
            else {
                help[i] = arr[p2++];

                for (int m = p1; m < mid+1; m ++){
                    System.out.println("("+ arr[m] +","+ help[i] +")");
                }

                i++;
            }
        }

        while (p1 < mid+1){
            help[i++] = arr[p1++];
        }

        while (p2 < r+1){
            help[i++] = arr[p2++];
        }

        for (int a = l; a < r+1; a++){
            arr[a] = help[a-l];
        }

        return;
    }


    public static void main(String[] args){
        int[] arr = new int[]{7,1,3,4,2,5,2};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
