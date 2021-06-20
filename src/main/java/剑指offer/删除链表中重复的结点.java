package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午3:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 15:31
 */
public class 删除链表中重复的结点 {

    public ListNode deleteDuplication(ListNode pHead) {

        ListNode cur = pHead;
        ListNode head=new ListNode(-1);
        head.next=pHead;
        ListNode pre = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (next!=null &&cur.val != next.val) {
                pre=cur;
                cur=cur.next;
            }else
            {
               if (next==null)
               {
                   break;
               }
                int val=cur.val;
                while (cur!=null &&cur.val == val) {
                    cur = cur.next;
                }
                pre.next=cur;
            }

        }
        return head.next;
    }

    @Test
    public void test()
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node31=new ListNode(3);
        ListNode node32=new ListNode(3);
        ListNode node41=new ListNode(4);
        ListNode node42=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node31;
        node31.next=node32;
        node32.next=node41;
        node41.next=node42;
        node42.next=node5;
        ListNode res=deleteDuplication(node1);
        System.out.println(res);


    }
}
