package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/14 下午2:50
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-14 14:50
 */
public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
        {
            return null;
        }
        ListNode oushuHead=head.next;
        ListNode jishu=head;
        ListNode oushu=head.next;



        while (oushu != null && oushu.next != null) {

            jishu.next = oushu.next;
            jishu=jishu.next;
            oushu.next=jishu.next;
            oushu=jishu.next;

        }
        jishu.next=oushuHead;


        return head;


    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode res = oddEvenList(node1);
        System.out.println(res);
    }
}
