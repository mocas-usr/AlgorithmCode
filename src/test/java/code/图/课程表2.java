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
public class 课程表2 {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] flags;
    Stack<Integer> stack = new Stack<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] course : prerequisites) {
            map.get(course[1]).add(course[0]);
        }
        flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int i=0;

        while (!stack.isEmpty())
        {
            res[i++]=stack.pop();
        }
        return res;
    }


    public boolean dfs(int index) {
        if (flags[index] == 1) {
            return false;
        }
        if (flags[index] == -1) {
            return true;
        }
        //当前选择
        flags[index] = 1;

        for (int path : map.get(index)) {
            //下一选择
            if (!dfs(path)) {
                return false;
            }
        }
        flags[index] = -1;
        stack.add(index);

        return true;
    }


    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[] res = findOrder(numCourses, prerequisites);
        System.out.println(res);
    }
}
