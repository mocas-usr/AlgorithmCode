package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/19 上午8:57
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;
import java.util.logging.Handler;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-19 08:57
 */
/*
有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。

        paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。

        另外，没有花园有 3 条以上的路径可以进入或者离开。

        你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。

        以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。

*/

public class 不邻接植花 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] ans = new int[N];//种植花的种类,1,2,3,4
        LinkedList<Integer>[] adj = new LinkedList[N + 1];//图的邻接矩阵
        //初始化矩阵,循环长度是n+1
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        //建立邻接表
        for (int[] temp : paths) {
            //建立邻接关系
            adj[temp[0]].add(temp[1]);
            adj[temp[1]].add(temp[0]);
        }

        //给花园种植
        for (int i = 1; i <= N; i++)//i代表花园号
        {
            //花园颜色
            boolean[] colors = new boolean[5];
            //先寻找邻接花园的颜色
            for (int t : adj[i])//adj[i]是包含了与i邻接的花园linklist
            {
                //邻接花园颜色设为true，
                colors[ans[t - 1]] = true;
            }
            //选花色
            for (int j = 1; j <= 4; j++)//j代表颜色
            {
                if (!colors[j]) {
                    ans[i - 1] = j;
                    break;
                }
            }

        }

        return ans;

    }

    //利用map节点进行处理
    public int[] gardenNoAdj2(int N, int[][] paths) {
        int[] ans = new int[N];//种植花的种类,1,2,3,4
        //邻接矩阵利用map存储
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        //初始化邻接矩阵
        for (int i = 0; i <= N; i++) {
            adj.put(i, new HashSet());
        }
        //建立邻接表
        for (int[] temp : paths) {
            //建立邻接关系
            int a = temp[0];
            int b = temp[1];
            adj.get(a).add(b);
            adj.get(b).add(a);

        }

        //给花园种植
        for (int i = 1; i <= N; i++)//i代表花园号
        {
            //花园颜色
            boolean[] colors = new boolean[5];
            //先寻找邻接花园的颜色
            for (int t : adj.get(i))//adj[i]是包含了与i邻接的花园linklist
            {
                //邻接花园颜色设为true，
                colors[ans[t - 1]] = true;
            }
            //选花色
            for (int j = 1; j <= 4; j++)//j代表颜色
            {
                if (!colors[j]) {
                    ans[i - 1] = j;
                    break;
                }
            }

        }

        return ans;
    }

    //暴力搜索
    public int[] gardenNoAdj3(int N, int[][] paths) {
        int[] ans = new int[N];//N个花园种植花的种类
        //构造邻接矩阵
        byte[][] map = new byte[N + 1][N + 1];
        for (int[] temp : paths) {
            map[temp[0]][temp[1]] = -1;
            map[temp[1]][temp[0]] = -1;
        }
        //花园种植
        HashSet<Integer> color = new HashSet<>();//用来保存花种类
        for (int i = 1; i <= N; i++)//i代表花园
        {
            //先看邻接
            color.clear();
            //寻找周围花园的颜色
            for (int j = 0; j <= N; j++) {
                if (map[i][j] == -1)//如果ij相邻，则i花园与j花园相邻
                {
                    color.add(ans[j - 1]);//j花园的颜色是ans[j-1]
                } else {

                }
            }
            //寻找结束
            for (int j = 1; j <= 4; j++)//j代表花园颜色
            {
                if (!color.contains(j))//排除周围花园颜色
                {
                    ans[i - 1] = j;
                    break;
                }
            }
        }
        return ans;

    }


    @Test
    public void test() {
        int N = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        int[] result = gardenNoAdj(N, paths);
        System.out.println(Arrays.toString(result));
    }


}
