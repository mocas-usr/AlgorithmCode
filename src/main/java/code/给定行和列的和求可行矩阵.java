package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/10 上午11:26
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-10 11:26
 */
public class 给定行和列的和求可行矩阵 {

    //贪心
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res=new int[rowSum.length][colSum.length];

        for (int i=0;i<rowSum.length;i++)
        {
            for (int j=0;j<colSum.length;j++)
            {
                int min=Math.min(rowSum[i],colSum[j]);
                res[i][j]=min;
                rowSum[i]-=min;
                colSum[j]-=min;

            }
        }
        return res;

    }
}
