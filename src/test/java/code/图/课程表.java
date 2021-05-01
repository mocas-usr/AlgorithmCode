package code.图;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午3:48
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 15:48
 */
public class 课程表 {

    //全局变量
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] flags;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //添加邻接关系
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] course : prerequisites) {
            map.get(course[1]).add(course[0]);
        }

        flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;

    }


    //搜索的课程
    public boolean dfs(int index) {

        //终止条件
        if (flags[index]==1)
        {
            //遇到环了，说明失败
            return false;
        }
        //剪枝
        if (flags[index]==-1)
        {
            return true;
        }
        //for 选择列表

        // 当前选择
        flags[index]=1;
        // 下一路径
        for (Integer t:map.get(index))
        {
            if (!dfs(t))
            {
                return false;
            }

        }
        // 恢复现场
        flags[index]=-1;
        return true;

    }

    @Test
    public void test()
    {
       int numCourses = 2;
       int[][] prerequisites = {{1,0}};
        boolean res=canFinish(numCourses, prerequisites);
        System.out.println(res);
    }
}
