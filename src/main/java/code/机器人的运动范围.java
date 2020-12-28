package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/13 下午4:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-13 16:19
 */
public class 机器人的运动范围 {

    //回溯
    public int movingCount(int m, int n, int k) {
       boolean[][] visited=new boolean[m][n];
       return dfs(0,0,m,n,visited,k);

    }

    //i代表搜索的横坐标，j代表纵坐标
    public int dfs(int i,int j,int m,int n,boolean[][] visited,int k)
    {

        //回溯终止条件

        if (i<0 ||i>=m || j<0 ||j>=n|| (i/10 + i%10 + j/10 + j%10) > k || visited[i][j])
        {
            return 0;
        }

        visited[i][j] = true;
        return dfs(i + 1, j, m, n, visited,k) + dfs(i - 1, j, m, n, visited,k) +
                dfs(i, j + 1, m, n, visited,k) + dfs(i, j - 1, m, n, visited,k) + 1;
    }

    @Test
    public void test()
    {

    }
}
