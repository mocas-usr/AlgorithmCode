package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午7:48
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 19:48
 */
public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence.length == 0) {
            return false;
        }
        boolean res = dfs(sequence, 0, sequence.length - 1);
        return res;
    }

    public boolean dfs(int[] nums, int left, int right) {
        if (left >= right) {
            return true;
        }
        //当前选择
        int root = nums[right];
        int index = left;
        while (index < right && nums[index] < nums[right]) {

            index++;
        }

        //index代表是右子树开始的地方
        //保证右子树全部大于root
        for (int i = index; i < right; i++) {
            if (nums[i] < nums[right]) {
                return false;
            }
        }
        boolean leftTree = dfs(nums, left, index - 1);
        boolean rightTree = dfs(nums, index, right - 1);

        return leftTree && rightTree;


    }


    @Test
    public void test() {
        int[] sequence={7,4,6,5};
        boolean res=VerifySquenceOfBST(sequence);
        System.out.println(res);
    }
}
