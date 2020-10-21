package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/14 下午4:32
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
 * @create: 2020-10-14 16:32
 */
public class 数组的相对排序2 {

    Map<Integer, Integer> record = new HashMap<>();

    //快速排序实现
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //记录arr2的数值
        for (int i = 0; i < arr2.length; i++) {
            //key是数值，val是序号
            record.put(arr2[i], i);
        }
        //取标准，进行排序
//        int standard=partition(arr1,0,arr1.length-1);
        quickSort(arr1, 0, arr1.length - 1);
        return arr1;
    }

    //快速排序
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //分段位置下标
            int stand = partition(arr, low, high);
            //左半段排序
            quickSort(arr, low, stand - 1);
            //右半段排序
            quickSort(arr, stand + 1, high);
        }


    }

    //取标准的key
    public int partition(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        //标准值取最右边的数值
        int temp = arr[left];
        //开始分配，比tmp小的在左边，比temp大的在右边，大小定义的规则是重点
        while (l < r) {
            //先看右边，依次往左递减,如果arr》temp
            while (less(temp, arr[r]) && l < r) {
                r--;
            }
            //再看左边，依次往右递增
            while (less(arr[l], temp) && l < r) {
                l++;
            }
            //如果满足条件则交换
            if (l < r) {
                swap(arr, l, r);
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        //交换到key位置
        swap(arr, l, left);
        return l;
    }

    public int partition2(int[] arr, int lo, int hi) {
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


    //交换
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*大小比较的准则*/
        /*大按题目要求我们知道，假设我们按升序排序，对于两个元素num1,num2，他们的比较有三种情况

        都存在于arr2中，按他们的下标进行比较，可类比为靠前的数更小
        其中一个存在于arr2，那么存在与arr2中的数靠前排，可认为更小
        两个数都不存在于arr2，那么很简单，直接比较两个数大小即可

        根据以上思路很容易想到用一个HashMap存储arr2中元素和小标的对应关系，便于比较*/
    public boolean less(int num1, int num2) {
        if (record.containsKey(num1) && record.containsKey(num2)) {
            return record.get(num1) <= record.get(num2);
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
