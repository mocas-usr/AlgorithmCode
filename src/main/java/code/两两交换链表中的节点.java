package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/27 下午3:00
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-27 15:00
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head==null)
            return null;
        //构建哨兵节点
        ListNode tmp=new ListNode(0);
        tmp.next=head;
        ListNode pre=tmp;

        //指针准备
        ListNode cur=head;
        while (cur!=null&&cur.next!=null)
        {
            ListNode next=cur.next;
            pre.next=next;
            //指针移动
            pre=cur;

            cur=next.next;
            pre.next=cur;
            next.next=pre;
        }
        return tmp.next;

    }


    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;//相当于cur
            ListNode end = temp.next.next;//next
            temp.next = end;
            //指针移动
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }


    public class ListNode
    {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
          this.val = val;
        }

        ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
        }
    }

    @Test
    public void test()
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        swapPairs2(node1);
    }



}
