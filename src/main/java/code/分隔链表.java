package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/20 下午8:24
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-20 20:24
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode(-1);
        temp.next=head;
        ListNode rightHead=new ListNode(-2);
        ListNode right=rightHead;
        ListNode pre = temp;
        ListNode cur = head;
        while (cur != null) {

            if (cur.val >= x) {
                right.next=cur;
                pre.next = cur.next;
                cur=pre.next;
                right=right.next;

            }else
            {
                pre = pre.next;
                cur = cur.next;
            }


        }
        right.next=null;
        pre.next=rightHead.next;

        return temp.next;


    }

    @Test
    public void test()
    {
        ListNode node1=new ListNode(1);
        ListNode node4=new ListNode(4);
        ListNode node3=new ListNode(3);
        ListNode node2=new ListNode(2);
        ListNode node5=new ListNode(5);
        ListNode node22=new ListNode(2);
        node1.next=node4;
        node4.next=node3;
        node3.next=node2;
        node2.next=node5;
        node5.next=node22;
        ListNode res=partition(node1, 3);
        System.out.println(res);
    }
}
