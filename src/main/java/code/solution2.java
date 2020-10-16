package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/12 下午6:28
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-12 18:28
 */
/*编写一个程序，找到两个单链表相交的起始节点。*/
public class solution2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //考虑为空
        if (headA==null || headB==null)
        {
            return null;
        }
        ListNode pa=headA;
        ListNode pb=headB;
        //a走的路程为a+c,b走的路程是b+c，同样走两段路，如果有交点，则在c处相遇
        while (pa!=pb)
        {
            pa=pa==null?headB:pa.next;
            pb=pb==null?headA:pb.next;
        }
        return pa;

    }

    public ListNode removeElements(ListNode head, int val) {
        //排除空元素
        if (head==null)
        {
            return null;
        }

        //哨兵节点，在首部加一个几点
        ListNode node=new ListNode(-1);
        node.next=head;
        //初始化节点
        ListNode pre=node;
        ListNode curr=head;
        //遍历删除
        while (curr!=null)
        {
            if (curr.val==val)
            {
                pre.next=curr.next;
                curr=curr.next;
            }
            else
            {
                pre=curr;
                curr=curr.next;
            }

        }
        return node.next;
    }

    @Test
    public void test()
    {
        List<ListNode> list=new LinkedList<>();





    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
}



