package code.图;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午3:48
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 15:48
 */
public class 课程表2 {
    //全局变量
    List<List<Integer>> adjacency = new ArrayList<>();
    int[] flag;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        flag = new int[numCourses];
        //多少课程
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new LinkedList<>());
        }
        //添加连接关系

        for (int[] course : prerequisites) {

            adjacency.get(course[1]).add(course[0]);
        }

        //回溯各节点
        for (int i = 0; i < numCourses; i++) {
            //如果搜索到环，则返回false
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    //回溯搜索,index代表搜索到第几位
    public boolean dfs(int index) {
        //终止条件
        if (flag[index] == 1) {
            return false;
        }
        //说明搜索到已经搜过的节点
        if (flag[index] == -1) {
            return true;
        }

        //for 选择列表

        //做选择
        flag[index] = 1;
        //下一路径
        for (int j : adjacency.get(index))//和index点相连接的下一个节点
        {
            if (!dfs(j)) {
                return false;
            }
        }
        //恢复现场
        flag[index] = -1;
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
