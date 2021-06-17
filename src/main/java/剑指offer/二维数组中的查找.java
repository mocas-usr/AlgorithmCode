package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午9:20
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 09:20
 */
public class 二维数组中的查找 {
    public boolean Find(int target, int[][] array) {

        int m = array.length;
        int n = array[0].length;
        if (m == 0) {
            return false;
        }
        //起始搜索位置
        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n ) {
            if (array[i][j]<target)
            {
                j++;
            }else if (array[i][j]>target)
            {
                i--;
            }else
            {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test()
    {

    }
}
