package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 下午7:26
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-08 19:26
 */
public class 柱状图中最大的矩形 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    @Test
    public void test()
    {
        int[] heights={2,1,5,6,2,3};
        int res=largestRectangleArea(heights);
        System.out.println(res);
    }

}
