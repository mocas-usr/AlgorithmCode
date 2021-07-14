package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/7 下午7:03
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-07 19:03
 */
public class 象棋 {

    public static int res = Integer.MAX_VALUE;
    public static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().trim().split(" ");
            int w = Integer.valueOf(str[0]);
            int h = Integer.valueOf(str[1]);

            char[][] grid = new char[w][h];
            visit = new boolean[w][h];
            //起点终点
            int x0 = -1;
            int y0 = -1;
            int x1 = -1;
            int y1 = -1;
            //多少行
            for (int i = 0; i < w; i++) {
                String[] hang = sc.nextLine().split(" ");
                //多少列
                for (int j = 0; j < h; j++) {
                    grid[i][j] = hang[j].charAt(0);
                    if (grid[i][j] == 'H') {
                        x0 = i;
                        y0 = j;
                    }
                    //终点
                    if (grid[i][j] == 'T') {
                        x1 = i;
                        y1 = j;
                    }
                    if (grid[i][j]=='#')
                    {
                        visit[i][j]=true;
                    }

                }

            }

            //num代表步数
            dfs(grid, x0, y0, x1, y1, 0);
            if (res!=Integer.MAX_VALUE)
            {
                System.out.println(res);
            }else
            {
                System.out.println(-1);
            }
        }
    }


    public static void dfs(char[][] grid, int i, int j, int x1, int y1, int num) {

        //终止条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        //剪枝
        if (visit[i][j]) {
            return;
        }
        if (grid[i][j]=='#')
        {
            return;
        }

        //当前操作
        visit[i][j] = true;
        num++;
        if (num>res)
        {
            return;
        }
        if(num>grid.length*grid[0].length)
        {
            return;
        }
        //满足条件
        if (i == x1 && j == y1) {
            res = Math.min(res, num);
            num--;
            visit[i][j] = false;
            return;
        }
        //下一路径
        if ((!(i< 0 || i >= grid.length || j+1 < 0 || j+1 >= grid[0].length)) &&(grid[i][j + 1] != '#')) {
            dfs(grid, i + 1, j + 2, x1, y1, num);
            dfs(grid, i - 1, j + 2, x1, y1, num);
        }
        if ((!(i+1< 0 || i+1 >= grid.length || j < 0 || j >= grid[0].length))&&(grid[i + 1][j] != '#')) {
            dfs(grid, i + 2, j + 1, x1, y1, num);
            dfs(grid, i + 2, j - 1, x1, y1, num);
        }
        if ((!(i-1< 0 || i-1 >= grid.length || j < 0 || j >= grid[0].length))&&(grid[i - 1][j] != '#')) {
            dfs(grid, i - 2, j + 1, x1, y1, num);
            dfs(grid, i - 2, j - 1, x1, y1, num);
        }
        if ((!(i< 0 || i >= grid.length || j-1 < 0 || j-1 >= grid[0].length))&&(grid[i][j - 1] != '#')) {
            dfs(grid, i - 1, j - 2, x1, y1, num);
            dfs(grid, i + 1, j - 2, x1, y1, num);

        }
        //恢复现场
        num--;
        visit[i][j] = false;

    }
}
