package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/13 下午7:11
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-13 19:11
 */
public class 八皇后 {
    List<List<String>> res = new ArrayList<>();
    char[][] grid;

    public List<List<String>> solveNQueens(int n) {
        grid=new char[n][n];
        //填充.
        for (char[] c:grid)
        {
            Arrays.fill(c, '.');
        }
        //第0行开始回溯起点
        dfs(n,0);
        return res;

    }
    private void dfs(int n, int i) {
        //终止条件
        if (i==n)
        {
            List<String> temp=new ArrayList<>();
            for (char[] c:grid)
            {
                temp.add(String.valueOf(c));
            }
            res.add(temp);
            return;
        }
        //for 循环列表
        // 当前路径
        for (int j=0;j<n;j++)
        {
            if (isValid(n,i,j))
            {
                grid[i][j]='Q';
                dfs(n,i+1);
                grid[i][j]='.';
            }

        }

        // 下一选择
        //恢复现场

    }


    public boolean isValid(int n,int i,int j)
    {
        //先判断同一行是否有数值
        for (int h=i,l=0;l<j;l++)
        {
            if (grid[h][j]=='Q')
            {
                return false;
            }
        }
        //判断同一行是否有皇后
        for (int h=0,l=j;h<i;h++)
        {
            if (grid[h][l]=='Q')
            {
                return false;
            }
        }

        //判断右斜
        for (int h=i,l=j;h>=0 &&l<n;h--,l++)
        {
            if (grid[h][l]=='Q')
            {
                return false;
            }
        }

        //判断左斜
        for (int h=i-1,l=j-1;h>=0 && l>=0;h--,l--)
        {
            if (grid[h][l]=='Q')
            {
                return false;
            }
        }
        return true;
    }




}
