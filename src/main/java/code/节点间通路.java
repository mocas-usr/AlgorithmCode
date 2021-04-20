package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/19 下午7:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-19 19:32
 */
public class 节点间通路 {

    //全局变量
    Map<Integer, Set<Integer>> map;
    int[] flag;
    boolean ans;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        flag=new int[n];
        map=new HashMap<>();
        for (int i=0;i<graph.length;i++)
        {
            map.put(i,new HashSet<>());
        }
        //构建有向图
        for (int [] num:graph)
        {
            map.get(num[0]).add(num[1]);
        }
        ans=false;
        boolean res=dfs(start,target);
        return res;



    }


    public boolean dfs(int index,int target) {
        //终止条件
        //遇到环了
        if (flag[index] == 1) {
            return false;
        }
        //重复搜索了
        if (flag[index] == -1)
        {
            return false;
        }
        if (target==index)
        {
            return true;
        }

        //剪枝
        //for 循环列表

        //  当前
        //标记搜寻过了
        flag[index]=1;
        // 下一路径
        if (map.get(index).contains(target))
        {
            return true;
        }
        for(int t:map.get(index))
        {
           if (dfs(t,target))
           {
               return true;
           }
        }
        // 恢复现场
        flag[index]=-1;
        return false;

    }

    @Test
    public void test()
    {

    }
}
