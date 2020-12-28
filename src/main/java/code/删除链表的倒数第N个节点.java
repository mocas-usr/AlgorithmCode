package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/28 下午6:59
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-28 18:59
 */
public class 删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)
        {
            return null;
        }
        //哨兵节点
        ListNode tmp=new ListNode(-1);
        tmp.next=head;
        ListNode pre=tmp;
        ListNode cur=tmp;
        //让cur先走n步
        for (int i=0;i<=n;i++)
        {
            cur=cur.next;
        }

        while (cur!=null)
        {

            //一起走
            pre=pre.next;
            cur=cur.next;
        }
        //cur=null时，pre是倒数第k个节点
        pre.next=pre.next.next;

        return tmp.next;
    }

    @Test
    public void test()
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        removeNthFromEnd(node1,2);
        System.out.println(node1);


    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}
