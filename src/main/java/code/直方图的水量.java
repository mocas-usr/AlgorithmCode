package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/16 上午11:06
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-16 11:06
 */
public class 直方图的水量 {

    //动态规划
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) {
            return 0;

        }
        //0到i的最大左边高度，包括i
        int[] leftHeight = new int[n];
        leftHeight[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        }

        int[] rightHeight = new int[n];
        rightHeight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }
        return ans;


    }

    //单调栈
    public int trap2(int[] height) {

        int n = height.length;
        if (n == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int hei = height[i];

            //当前高度高于栈顶高度
            while (!stack.isEmpty() && hei > height[stack.peek()]) {
                int top = stack.pop();
                //如果为空。则直接跳出，不存水
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];
                res += (curWidth * curHeight);
            }
            stack.push(i);
        }
        return res;
    }

    @Test
    public void test()
    {
        int[] height=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
       int  res=trap2(height);
        System.out.println(res);
    }


}
