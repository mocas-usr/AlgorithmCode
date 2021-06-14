package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/13 上午11:02
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-13 11:02
 */
public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> ansList = new LinkedList<>();
        boolean insert = false;
        for (int[] interval : intervals) {
            //区间在现在区间的左边，说明已经进行合并处理过了
            if (interval[0] > right) {
                if (!insert) {
                    ansList.add(new int[]{left, right});
                    insert = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                //不知道进行合并没有
                //只有新区间在本区间左边才合并
                //在右边
                ansList.add(interval);
            } else {
                //有重合
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!insert) {
            ansList.add(new int[]{left, right});
            insert = true;
        }
        int[][] res = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            res[i] = ansList.get(i);
        }
        return res;
    }

    @Test
    public void test()
    {
        int[][]intervals ={{1,3},{6,9}};
        int[] newInterval ={2,5};
        int[][] res=insert(intervals,newInterval);
        System.out.println(res);
    }
}
