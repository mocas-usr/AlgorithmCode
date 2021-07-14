package code.图;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/22 下午8:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-22 20:32
 */
public class 不邻接植花 {

    public int[] gardenNoAdj(int n, int[][] paths) {

        Map<Integer, Set<Integer>> map=new HashMap<>();

        //初始化图
        for (int i=1;i<=n;i++)
        {
            map.put(i,new HashSet<>());
        }
        for (int[] path:paths)
        {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);

        }

        int[] res=new int[n+1];

        for (int i=1;i<=n;i++)
        {

            boolean[] colors=new boolean[5];
            //标记哪些颜色用过了
            for (int num:map.get(i))
            {
                //num是相邻的花坛
                int color=res[num];//相邻花坛颜色
                colors[color]=true;
            }

            //标记本地的颜色
            for (int k=1;k<=4;k++)
            {
                if (!colors[k])
                {
                    res[i]=k;
                }
            }


        }

        int[] ans=new int[n];

        for (int i=0;i<n;i++)
        {
            ans[i]=res[i+1];
        }
        return ans;
    }


}
