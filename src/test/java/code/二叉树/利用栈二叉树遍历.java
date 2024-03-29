package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/3 下午8:01
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-03 20:01
 */
public class 利用栈二叉树遍历 {
    /**
     * 统一一下
     * @param root
     * @return
     */
    //前序
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            //一直往左压入栈
            while(cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    //中序
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }


    //后序遍历，非递归
    public static List<Integer> postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode p = null;//用来记录上一节点
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
//            后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
//            如果是从右边再返回根结点，应该回到上层。
            //主要就是判断出来的是不是右子树，是的话就可以把根节点=加入到list了
            if(cur.right == null || cur.right == p){
                list.add(cur.val);
                stack.pop();
                p = cur;
                cur = null;
            }else{
                cur = cur.right;
            }

        }
        return list;
    }
}
