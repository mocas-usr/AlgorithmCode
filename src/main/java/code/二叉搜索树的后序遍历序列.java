package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/15 下午3:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-15 15:04
 */
public class 二叉搜索树的后序遍历序列 {

    public boolean verifyPostorder2(int[] postorder) {
        //通过回溯实现，分别回溯左右子树
        return recurPost(postorder,0,postorder.length-1);
    }

    //递归这个子树
    public boolean recurPost(int[] postOrder,int left,int right) {
        //递归终止条件
        if (left > right) {
            return true;
        }

        int cur = left;//从左边开始
        //寻找左右子树分界线
        //左子树都是小于root的，root是right索引位置
        while (postOrder[cur] < postOrder[right]) {
            cur++;
        }
        //现在cur的数值就是右子树开始的地方
        int m=cur;//记住右子树开始的地方
        while (postOrder[cur] > postOrder[right])
        {
            cur++;
        }
        //如果满足cur==right，则说明整体满足
        if (cur==right && recurPost(postOrder,left,m-1) && recurPost(postOrder,m,right-1))
        {
            return true;
        }else
        {
            return false;
        }


    }

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


    @Test
    public void test()
    {
        int[] nums={1,3,2,6,5};
        verifyPostorder(nums);
    }
}
