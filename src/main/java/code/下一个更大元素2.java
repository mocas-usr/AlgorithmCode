package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/3/6 22:22
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-03-06 22:22
 */
public class 下一个更大元素2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n*2; i++){
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()]){
                res[stack.pop()] = num;
            }
            if(i < n) stack.add(i);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums={1,2,1};
        int[] res=nextGreaterElements(nums);
        System.out.println(1);
    }
}
