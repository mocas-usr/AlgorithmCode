package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 上午10:57
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-22 10:57
 */
public class 迷路的机器人 {
    //全局变量
    List<List<Integer>> res;
    //只要求一条路线
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        res = new LinkedList<>();
        if (dfs(obstacleGrid, 0, 0))
        {
            return res;
        }else
        {
            return new LinkedList<>();
        }

    }

    public boolean dfs(int[][] grid, int i, int j) {
        List<Integer> list = new LinkedList<>();
        //终止条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return false;
        }

        //当前选择
        list.add(i);
        list.add(j);
        res.add(list);
        //下一路径

        if ((i == grid.length - 1 && j == grid[0].length-1) || dfs(grid, i + 1, j) || dfs(grid, i , j+1)) {
            return true;

        }
        //恢复现场
        res.remove(res.size()-1);
        //到达这里则说明i,j无论如何都到达不了终点
        grid[i][j]=1;
        return false;

    }

    @Test
    public void test()
    {
        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        List<List<Integer>> res=pathWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
