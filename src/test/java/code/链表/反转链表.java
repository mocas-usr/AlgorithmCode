package code.链表;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 下午3:28
 * @email: wangyuhang_mocas@163.com
 */

import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-25 15:28
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;

        }

        newHead.next=null;
        return pre;

    }
}
