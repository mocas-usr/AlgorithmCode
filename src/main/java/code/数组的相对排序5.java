package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/16 下午3:33
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
 * @create: 2020-10-16 15:33
 */
public class 数组的相对排序5 {
    Map<Integer, Integer> record;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        //赋值
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }

        shellSort(arr1);
        return arr1;
    }

    //shell排序
    public void shellSort(int[] arr) {
        int len = arr.length;

        for (int gap = len / 2; gap > 0; gap = gap / 2)
            for (int i = gap; i < len; i++) {
                //插入排序排每一个数，在不同的组下
                insert(arr, gap, i);
            }

    }

    //插入排序，排列步长为gap的数组
    public void insert(int[] arr, int gap, int i) {
        int temp = arr[i];
        int j;
        //将arr[j]放到合适的位置
        for (j = i - gap; j >= 0 && (less(temp, arr[j])); j -= gap) {
            arr[j + gap] = arr[j];
        }
        arr[j + gap] = temp;
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
