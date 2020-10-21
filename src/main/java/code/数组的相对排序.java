package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/14 上午9:41
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-14 09:41
 */
public class 数组的相对排序 {
    //计数排序，时间复杂度o(n),空间o（n）
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        // 将 arr1 中的数记录下来
        for (int num1 : arr1) {
            count[num1]++;
        }
        // 先安排 arr2 中的数
        int i = 0;
        for (int num2 : arr2) {
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }
        // 再排剩下的数
        for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[i++] = num1;
                count[num1]--;
            }
        }
        return arr1;
    }

    //计数排序
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        //计数数组
        int[] nums = new int[10001];

        //计数数组赋值
        for (int x : arr1) {
            nums[x]++;//代表值为x
        }
        //[0 2 1 2 2]代表有2个1，1个2,2个3和2个4
        //按照arr2数组分配排序
        int i = 0;
        for (int num : arr2) {
            //如果存在对应数值
            while (nums[num] > 0) {
                arr1[i++] = num;
                nums[num]--;
            }

        }
        //分配arr2结束

        //开始分配剩余数值
        for (int t = 0; t < nums.length; t++) {
            while (nums[t] > 0) {
                arr1[i++] = t;
                nums[t]--;
            }
        }

        return arr1;
    }


    //快速排序
    Map<Integer, Integer> record;

    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        quickSort(arr1, 0, arr1.length - 1);
        return arr1;
    }

    public void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }

    public int partition(int[] arr, int lo, int hi) {
        int temp = arr[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (less(arr[i], temp)) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j, hi);
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int[] arr = relativeSortArray3(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }
}
