package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/9 19:56
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-09 19:56
 */
public class 不同路径 {

    //动态规划
    public int uniquePaths(int m, int n)
    {
        int[][] dp=new int[m][n];
        //到达第一行或者第一列的方式只有一种
        for (int i=0;i<m;i++)
        {
           dp[i][0]=1;
        }
        for (int j=0;j<n;j++)
        {
            dp[0][j]=1;
        }

        //
        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++)
            {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        return dp[m-1][n-1];
    }


    //全局变量
    int num;
    //递归回溯
    public int uniquePaths2(int m, int n) {
        num=0;
        //搜索起点
        dfs(m,n,0,0);

        return num;
    }

    //回溯
    public void dfs(int m,int n,int i,int j)
    {
        //终止条件
        if (i==m&&j==n)
        {
            num=num+1;
            return;
        }
        //剪枝
        if (i<0 ||i>m ||j<0 ||j>n)
        {
            return;
        }

        //for 选择列表
        //做选择
        //下一搜索路径
        dfs(m,n,i+1,j);
        dfs(m,n,i,j+1);
        //恢复现场
        return;



    }

    @Test
    public void test()
    {
        int res=uniquePaths(3,3);
        System.out.println(res);
    }
}
