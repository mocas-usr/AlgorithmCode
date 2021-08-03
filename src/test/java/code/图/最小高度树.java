package code.图;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/21 下午5:12
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-21 17:12
 */
public class 最小高度树 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        //建立各个表的出度
        int[] degree = new int[n];
        //建立图关系
        List<List<Integer>> map = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        //建立队列
        Queue<Integer> queue = new LinkedList<>();
        /*把所有出度为1的节点，也就是叶子节点入队*/
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                queue.offer(i);
        }


        while (!queue.isEmpty()) {
            res=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int cur=queue.poll();
                res.add(cur);

                List<Integer> neighbors=map.get(cur);
                for (int nei:neighbors)
                {
                    degree[nei]--;
                    if (degree[nei]==1)
                    {
                        queue.offer(nei);
                    }
                }
            }
        }
        return res;

    }
}
