package code.链表;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午8:29
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 20:29
 */
public class 分割链表 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode lowHead = new ListNode(-1);
        ListNode highHead = new ListNode(-1);
        ListNode low = lowHead;
        ListNode high = highHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                low.next = cur;
                low=low.next;
            } else {
                high.next = cur;
                high=high.next;
            }
            cur = cur.next;
        }
        //拼接
        low.next = highHead.next;
        high.next = null;
        return lowHead.next;


    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
