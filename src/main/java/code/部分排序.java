package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 下午2:21
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-01 14:21
 */
public class 部分排序 {

    public int[] subSort(int[] array) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = array.length;
        int start = -1;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] < max) {
                end = i;
            } else {
                max = array[i];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (array[i]>min)
            {
                start=i;
            }else
            {
                min=array[i];
            }
        }

        if (start==-1)
        {
            return new int[]{-1,-1};
        }else
        {
            return new int[]{start,end};
        }



    }

    @Test
    public void test()
    {
        int[] array={1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] res=subSort(array);
        System.out.println(res);
    }
}
