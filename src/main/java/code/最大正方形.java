package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 上午10:11
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-09 10:11
 */
public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {

        if (matrix.length==0 || matrix[0].length==0)
        {
            return 0;
        }
        int maxSide=0;
        int m=matrix.length;
        int n=matrix[0].length;
        //dp[i][j]代表i，j右下角的矩形面积
        int[][] dp=new int[m][n];
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[0].length;j++)
            {
                if (matrix[i][j]=='1')
                {

                    if (i==0 ||j==0)
                    {
                        dp[i][j]=1;

                    }else
                    {
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }

                    maxSide=Math.max(dp[i][j],maxSide);
                }
            }


        return maxSide*maxSide;

    }
}
