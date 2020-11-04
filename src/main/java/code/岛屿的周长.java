package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/30 上午9:16
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-30 09:16
 */
public class 岛屿的周长 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    //暴力查找
    public int islandPerimeter(int[][] grid) {

        int ans=0;//周长

        int n=grid.length;//行数
        int m=grid[0].length;


        //i代表行数，j代表列数
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
            {   //如果这一行为1
                if (grid[i][j]==1)
                {
                    //查看上下左右的邻接是否有值
                    for (int k=0;k<4;k++)
                    {
                        int tx=i+dx[k];//相邻方格的横坐标
                        int ty=j+dy[k];
                        //边界或者相邻为0
                        if (tx<0 || tx>=n ||ty<0 ||ty>=m ||grid[tx][ty]==0)
                        {
                            ans=ans+1;
                        }
                    }
                }


            }


        return ans;
    }



    // dfs
    public int islandPerimeter2(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        //i代表行数，j代表列数
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
            {
                if (grid[i][j]==1)
                {
                   ans=ans+ dfs(grid,i,j);
                }
            }
        return ans;
    }

    int dfs(int[][] grid, int r, int c) {

        //求值,如果是边缘
        if (r<0 || r>=grid.length ||c<0 || c<grid[0].length)
        {
            return 1;
        }
        //如果是没有数值
        if (grid[r][c]==0)
        {
            return 1;
        }
        //停止条件
        if (grid[r][c] != 1) {
            return 0;
        }
        //标记为已经查看
        grid[r][c] = 2;

        //上下左右的高度
        int right=dfs(grid,r,c+1);
        int down=dfs(grid,r+1,c);
        int left=dfs(grid,r,c-1);
        int up=dfs(grid,r-1,c);

        int sum=right+left+down+up;
        return sum;

    }

    @Test
    public void test()
    {
       int[][] nums= {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        islandPerimeter2(nums);
    }
}
