package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/13 下午6:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-13 18:32
 */
public class 无重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        int res=0;
        int left=intervals[0][0];
        int right=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0]<right)
            {
                res++;
            }else
            {
                left=intervals[i][0];
                right=intervals[i][1];

            }
        }

        return res;
    }

    @Test
    public void test()
    {

    }
}
