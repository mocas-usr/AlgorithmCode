package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 下午4:42
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-31 16:42
 */

public class 对链表进行插入排序 {

    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        //初始化操作
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode sorted = head;
        ListNode cur = head.next;//cur开始遍历

        while (cur != null) {
            if (cur.val >= sorted.val) {
                sorted = sorted.next;
            } else {
                ListNode pre = newHead;

                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                //完成插入
                sorted.next=cur.next;
                cur.next=pre.next;
                pre.next=cur;

            }
            cur = sorted.next;
        }
        return newHead.next;
    }
}
