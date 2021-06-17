package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午11:23
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 11:23
 */
public class 合并两个排序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode newHead = new ListNode(-1);
        ListNode head=newHead;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val > l2.val) {
                node = new ListNode(l2.val);
                l2 = l2.next;

            } else {
                node = new ListNode(l1.val);
                l1 = l1.next;
            }
            newHead.next = node;
            newHead=newHead.next;
        }

        if (l1 != null) {
            newHead.next = l1;
        }
        if (l2 != null) {
            newHead.next = l2;
        }
        return head.next;
    }
}
