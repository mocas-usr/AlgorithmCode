package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/16 上午9:13
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-16 09:13
 */
public class 螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res=new LinkedList<>();

        int left=0;
        int right=matrix[0].length-1;
        int shang=0;
        int xia=matrix.length-1;
        while (true)
        {
            //从左到右打印
            for (int j=left;j<=right;j++)
            {
                res.add(matrix[shang][j]);
            }
            //
            if (++shang>xia)
            {
                break;
            }
            //从上到下
            for (int i=shang;i<=xia;i++)
            {
                res.add(matrix[i][right]);
            }
            if (--right<left)
            {
                break;
            }
            //从右往左
            for (int j=right;j>=left;j--)
            {
                res.add(matrix[xia][j]);
            }
            if (--xia<shang)
            {
                break;
            }
            //从上到下
            for (int i=xia;i>=shang;i--)
            {
                res.add(matrix[i][left]);
            }
            if (++left>right)
            {
                break;
            }


        }
        return res;

    }

    @Test
    public void test()
    {
        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res=spiralOrder(matrix);
        System.out.println(res);
    }
}
