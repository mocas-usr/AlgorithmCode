package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/10 下午3:00
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-10 15:00
 */
public class 统计参与通信的服务器 {
    //遍历
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        //记录行和列存在的主机数量
        int[] count_n=new int[n];
        int[] count_m=new int[m];

        //计数标记
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j]==1)
                {
                    //行和列的计数+1
                    count_m[j]++;
                    count_n[i]++;
                }
            }
        }
        int ans=0;
        //统计数量
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
            {
                //如果行列的主机大于1，则说明通信
                if (grid[i][j]==1 &&(count_m[j]>1 || count_n[i]>1))
                {
                  ans+=1;
                }
            }
        return ans;

    }

    @Test
    public void test()
    {
        int[][] grid= {{1,0},{1,1}};
        countServers(grid);
    }
}
