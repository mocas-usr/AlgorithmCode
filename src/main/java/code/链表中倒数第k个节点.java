package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/26 下午8:48
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-26 20:48
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd2(ListNode head, int k) {

        if (head==null)
        {
            return null;
        }
        //指针遍历
        ListNode cur=head;
        //栈
        Stack<ListNode> stack=new Stack<>();
        while (cur!=null)
        {
            stack.push(cur);
            cur=cur.next;

        }
        //结果
        ListNode res=null;
        while (k>0)
        {
            res=stack.pop();
            k--;
        }
        return res;


    }

    //双指针
    public ListNode getKthFromEnd(ListNode head, int k)
    {
        //初始化
        ListNode right=head;
        ListNode left=head;

        //让右边先走k步数
        for (int i=0;i<k;i++)
        {
            right=right.next;
        }
        //右边比左边快k步
        while (right!=null)
        {
            right=right.next;
            left=left.next;
        }
        return left;
    }

       public class ListNode {
        int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
}
