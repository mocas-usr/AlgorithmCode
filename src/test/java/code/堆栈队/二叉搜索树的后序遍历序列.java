package code.堆栈队;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午7:28
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-20 19:28
 */
public class 二叉搜索树的后序遍历序列 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }

        boolean res = dfs(postorder, 0, postorder.length - 1);
        return res;

    }

    public boolean dfs(int[] nums, int left, int right) {
        //终止条件
        if (left > right) {
            return true;
        }
        //当前选择
        int index = left;
        //左右子树分割点
        while (index < right && nums[index] < nums[right]) {
            index++;
        }
        //index 为右子树第一个
        for (int i = index; i < right; i++) {
            //如果有小于的，则为false
            if (nums[i] < nums[right]) {
                return false;
            }
        }
        //下一路径

        boolean leftTree = dfs(nums, left, index - 1);
        boolean rightTree = dfs(nums, index, right-1);
        return leftTree && rightTree;


    }

    @Test
    public void test()
    {
        int[] postorder={1,2,5,10,6,9,4,3};
        boolean res=verifyPostorder(postorder);
        System.out.println(res);
    }
}
