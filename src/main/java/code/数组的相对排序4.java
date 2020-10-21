package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/16 上午10:05
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-16 10:05
 */
public class 数组的相对排序4 {
    Map<Integer, Integer> record;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        //放入数组
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        //归并排序
        mergeSort(arr1, 0, arr1.length - 1);
        return arr1;
    }

    //分割归并
    public void mergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = (high - low) / 2 + low;
            //分割
            //左边
            mergeSort(arr, low, mid);
            //右边
            mergeSort(arr, mid + 1, high);
            //合并
            merge(arr, low, mid, high);

        }

    }

    //合并的操作
    public void merge(int[] arr, int low, int mid, int high) {
        //指针
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        //先将较小的数放入temp
        while (i <= mid && j <= high) {
            //
            if (less(arr[i], arr[j])) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //将剩余的数直接放入
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        //将数组赋值
        for (int h = 0; h < temp.length; h++) {
            arr[low + h] = temp[h];
        }
    }

    public void merge2(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = lo;
        int j = mid + 1;
        for (int k = 0; k < temp.length; k++) {
            if (i > mid) {
                temp[k] = arr[j++];
            } else if (j > hi) {
                temp[k] = arr[i++];
            } else if (less(arr[i], arr[j])) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }
        for (int k = 0; k < temp.length; k++) {
            arr[lo + k] = temp[k];
        }
    }


    public boolean less(int num1, int num2) {
        if (record.containsKey(num1) && record.containsKey(num2)) {
            return record.get(num1) < record.get(num2);
        } else if (record.containsKey(num1)) {
            return true;
        } else if (record.containsKey(num2)) {
            return false;
        } else {
            return num1 < num2;
        }
    }

    @Test
    public void test() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        int[] arr = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }


}
