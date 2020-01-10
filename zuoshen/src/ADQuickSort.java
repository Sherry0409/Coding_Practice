import java.util.Arrays;

public class ADQuickSort {
    public static void quickSort(int[] arr, int l, int r){
        //exception situation
        if (arr == null || arr.length < 2){
            return;
        }

        //如果设定为相等区域的边界就可以少考虑一些溢出情况 即if(l==r)
        if (l >= r){
            return;
        }

        int[] border = quick(arr, l, r);
//        System.out.println(Arrays.toString(border) + " " + l + " " + r);
//        System.out.println(Arrays.toString(arr));
        quickSort (arr, l, border[0]);
        quickSort (arr, border[1], r);
        return;
    }


    public static int[] quick(int[] arr, int l, int r){

        //使用随机快排的方法，也可以先将random number swap到数组最后，然后每次都将数组最后一个数作为标准数
        int standardNum = arr[l + (int) (Math.random() * (r-l+1))];
//        System.out.println(standardNum);
        int curr = l;

        //核心就是找清楚三个指针，相对简单的方式就是多设置几个变量
        // three pivot: left border l-1, right border r+1, current number curr
        while (curr < r+1){
            if (arr[curr] < standardNum){
                if (curr == l){
                    l++;
                    curr++;
                }
                else {
//                    System.out.println(l);
//                    System.out.println(curr);
                    swap(arr, l++, curr++);
                }

            }
            else if (arr[curr] == standardNum){
                curr++;
            }
            else if (arr[curr] > standardNum){
//                System.out.println(r);
                swap(arr, curr, r--);
            }
//            System.out.println(Arrays.toString(arr));
        }

        return (new int[]{l-1, r+1});
    }

    public static void swap (int[] arr, int a, int b){
        //一般swap报错都是由于指针溢出
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return;
    }

    public static void main(String[] args){
        int[] test = new int[]{2,6,1,15,9,33,2,0};
        quickSort(test, 0, test.length-1);
        System.out.println(Arrays.toString(test));

    }
}
