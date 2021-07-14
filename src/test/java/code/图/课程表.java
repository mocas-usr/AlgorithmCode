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

    //
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //建图
        //初始化
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] pre : prerequisites) {
            map.get(pre[1]).add(pre[0]);

        }
        flags=new int[numCourses];

        //查看遇到环
        for (int i = 0; i < numCourses; i++) {
            //遇到环了
            if (!dfs(i)) {
                return false;
            }

        }
        return true;


    }

    //true代表没有环，false代表有环
    public boolean dfs(int index) {
        //终止条件
        if (flags[index] == 1) {//说明遇到环了
            return false;
        }
        // 这说明已经搜索过了
        if (flags[index] == -1) {
            return true;
        }
        // 当前选择
        flags[index] = 1;
        // 下一路径
        for (int path : map.get(index)) {
            //遇到环了
            if (!dfs(path)) {
                return false;
            }
        }

        // 恢复现场
        flags[index]=-1;
        return true;
    }

    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean res = canFinish(numCourses, prerequisites);
        System.out.println(res);
    }
}
