package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午3:17
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 15:17
 */
public class 链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;
        ListNode index = null;
        while (fast != null) {

            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (slow == fast) {
                index = slow;
                break;
            }

        }

        fast = pHead;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }


}
