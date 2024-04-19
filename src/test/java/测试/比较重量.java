package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/11 15:36
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-11 15:36
 */
public class 比较重量 {

    List<Integer> visit=new LinkedList<>();
    public int cmp(int g1, int g2, int[][] records, int n) {
        // write code here

        //key比val大
        Map<Integer, Set<Integer>> map = new HashMap<>();


        for (int i = 0; i < records.length; i++) {
            if (!map.containsKey(records[i][0]))
            {
                map.put(records[i][0], new HashSet<>());
            }
            map.get(records[i][0]).add(records[i][1]);
        }

        boolean res = dfs(g1, g2, map);
        if (res)
        {
            return 1;
        }
        boolean res2=dfs(g2,g1,map);

        if (res2)
        {
            return -1;
        }

        return 0;

    }

    public boolean dfs(int g1, int g2,  Map<Integer, Set<Integer>> map) {
        //终止条件
        if (g1==g2)
        {
            return true;
        }
        //已经访问过了
        if (visit.contains(g1))
        {
            return false;
        }

        //当前选择
        visit.add(g1);
        for (int num:map.get(g1))
        {
            //下一路径
            if (dfs(num,g2,map))
            {
                return true;
            }

        }
        //恢复现场
        visit.remove(visit.size()-1);
        return false;

    }

    @Test
    public void test() {
        int g1=2; int g2=3;
        int[][] records={{1,3},{2,4},{1,3},{4,3}};
        int n=4;
        int res=cmp(g1,  g2,  records,  n);
        System.out.println(res);
    }
}
