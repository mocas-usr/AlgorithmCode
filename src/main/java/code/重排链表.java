package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/27 下午9:30
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-27 21:30
 */
public class 重排链表 {

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        //找到中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        //反转后半段
        ListNode rightHead = slow.next;
        slow.next=null;
        ListNode pre = null;
        ListNode cur = rightHead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
//        rightHead.next = null;
        //融合

        ListNode l1 = head;
        ListNode l11 = null;
        ListNode l2 = pre;
        ListNode l22 = null;
        int i = 0;
        while (l1 != null && l2 != null) {
            l11 = l1.next;
            l22 = l2.next;

            l1.next = l2;
            l2.next = l11;

            l1 = l11;
            l2 = l22;
        }

        return;
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

        reorderList(node1);
        System.out.println(node1);

    }
}
