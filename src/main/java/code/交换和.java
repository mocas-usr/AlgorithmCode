package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 下午3:20
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-01 15:20
 */
public class 交换和 {

    public int[] findSwapValues2(int[] array1, int[] array2) {

        int sum1 = 0;
        for (int arr : array1) {
            sum1 += arr;
        }

        int sum2 = 0;
        for (int arr : array2) {
            sum2 += arr;
        }

        int delta = sum1 - sum2;
        if (delta % 2 == 1) {
            return new int[0];
        }

        int a1 = 0;
        int a2 = 0;
        Arrays.sort(array1);
        Arrays.sort(array2);

        while (a1 < array1.length && a2 < array2.length) {
            if ((array1[a1] - array2[a2]) * 2 > delta) {
                a2++;
            } else if ((array1[a1] - array2[a2]) * 2 < delta) {
                a1++;
            } else {
                return new int[]{array1[a1], array2[a2]};
            }
        }
        return new int[0];

    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        for (int arr : array1) {
            sum1 += arr;
        }

        int sum2 = 0;
        for (int arr : array2) {
            sum2 += arr;
        }

        int delta = sum1 - sum2;
        if ((delta&1)==1) {
            return new int[0];
        }

        delta=delta/2;

        Set<Integer> set=new HashSet<>();

        for (int x:array1)
        {
            set.add(x-delta);
        }

        for (int y:array2)
        {
            if (set.contains(y))
            {
                return new int[]{y+delta,y};
            }
        }
        return new int[]{};
    }

    @Test
    public void test() {

        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] res = findSwapValues(array1, array2);
        System.out.println(res);
    }
}
