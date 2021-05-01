package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午3:01
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 15:01
 */
public class 课程表2 {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] flags;
    Stack<Integer> stack = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //建立连接关系
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] course : prerequisites) {
            map.get(course[1]).add(course[0]);
        }
        flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i))
            {
             return new int[0];
            }
        }

        int[] res=new int[numCourses];
        int i=0;
        while (!stack.isEmpty())
        {

            res[i++]=stack.pop();
        }
        return res;

    }

    public boolean dfs(int index) {
        //终止条件
        if (flags[index] == 1) {
            //存在环
            return false;
        }
        if (flags[index] == -1) {
            return true;
        }
        //for 选择列表
        // 当前选择
        flags[index]=1;
        //下一路径
        for (Integer t:map.get(index))
        {
            if (!dfs(t))
            {
             return false;
            }
        }
        //恢复现场
        flags[index]=-1;
        //不会添加重复元素
        stack.push(index);
        return true;

    }

    @Test
    public void test()
    {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        int[] res=findOrder(numCourses,prerequisites);
        System.out.println(res);
    }


}
