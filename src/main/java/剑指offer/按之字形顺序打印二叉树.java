package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午4:16
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 16:16
 */
public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int width = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            width++;
            while (size > 0) {

                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                size--;
            }
            if (width%2==0)
            {
                reverseList(list);
            }
            res.add(new ArrayList<>(list));

        }
        return res;
    }

    private void reverseList(ArrayList<Integer> list) {

        if (list.size()==0)
        {
            return;
        }

        int left=0;
        int right=list.size()-1;

        while (left<right)
        {
            int temp=list.get(left);
            list.set(left,list.get(right));
            list.set(right,temp);
            left++;
            right--;
        }
    }
}
