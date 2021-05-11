package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/11 下午8:00
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-11 20:00
 */
public class 特定深度节点链表 {

    public ListNode[] listOfDepth(TreeNode tree) {

        if (tree==null)
        {
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(tree);
        List<ListNode> list=new LinkedList<>();
        while (!queue.isEmpty())
        {
            int size=queue.size();
            ListNode temp=new ListNode(0);
            ListNode cur=temp;
            while (size>0)
            {
                TreeNode node=queue.poll();
                if (node.left!=null)
                {
                    queue.offer(node.left);
                }
                if (node.right!=null)
                {
                    queue.offer(node.right);
                }
                ListNode listNode=new ListNode(node.val);
                cur.next=listNode;
                cur=cur.next;
                size--;
            }
            list.add(temp.next);
        }

        ListNode[] res=new ListNode[list.size()];
        for (int i=0;i<list.size();i++)
        {
            res[i]=list.get(i);
        }
        return res;

    }


}
