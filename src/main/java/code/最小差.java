package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/30 下午8:40
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-30 20:40
 */
public class 最小差 {
    public int smallestDifference(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);
        int left = 0;
        int right = 0;

        //
        long res =Long.MAX_VALUE;
        Long temp = Long.MAX_VALUE;
        while (left < a.length && right < b.length) {
            //left比较小
            if (a[left] < b[right]) {
                temp = (long)b[right] - (long)a[left];
                left++;
            } else {
                temp = (long)a[left] - (long)b[right];
                right++;
            }

            res = Math.min(res, temp);
        }

        return (int)res;

    }

    @Test
    public void test()
    {
        int[] a={-2147483648,1};
        int[] b={2147483647,0};
        int res=smallestDifference(a,b);
        System.out.println(res);

    }



}
