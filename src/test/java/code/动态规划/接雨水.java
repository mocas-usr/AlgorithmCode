package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/21 下午5:17
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-21 17:17
 */
public class 接雨水 {
    //单调栈
    public int trap(int[] height) {

        //保持递减栈
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < height.length; i++) {

            //如果栈此时大于栈顶
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //开始出栈
                int top = stack.pop();
                //如果这时没有了，则不存水
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[top];
                res += curHeight * curWidth;
            }
            stack.push(i);
        }
        return res;
    }
}
