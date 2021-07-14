package code.链表;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 下午8:55
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-31 20:55
 */
public class 对链表进行插入排序 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        //已经排序的
        ListNode sorted = head;
        ListNode cur = head.next;//将要排序的

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        while (cur != null) {

            if (cur.val >= sorted.val) {
                sorted = sorted.next;
            } else {
                //说明此时要向前遍历
                ListNode pre = newHead;
                ListNode curNode = newHead.next;
                while (curNode.val < cur.val) {
                    curNode = curNode.next;
                    pre = pre.next;
                }
                //插入
                sorted.next = cur.next;
                pre.next = cur;
                cur.next = curNode;

            }
            //移动
            cur = sorted.next;
        }
        return newHead.next;


    }
}
