package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/30 下午8:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-30 20:18
 */
public class 交换链表中的节点 {

    public ListNode swapNodes(ListNode head, int k) {

        //寻找第k个节点

        ListNode cur=head;
        while (k>1)
        {
            cur=cur.next;
            k--;
        }

        ListNode node1=cur;
        //寻找倒数k个节点
        ListNode kNode=head;

        while (cur.next!=null)
        {
            cur=cur.next;
            kNode=kNode.next;
        }

        //交换
        int temp=node1.val;
        node1.val=kNode.val;
        kNode.val=temp;
        return head;



    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        swapNodes(node1, 2);
        System.out.println(node1);

    }
}
