package code.链表;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 下午8:55
 * @email: wangyuhang_mocas@163.com
 */

import java.util.List;

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

        ListNode temp = new ListNode(-1);
        temp.next = head;
        //排好序的链表
        ListNode sorted = temp;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val > sorted.val) {
                sorted = sorted.next;
                cur=sorted.next;
            } else {
                ListNode pre = temp;
                ListNode index = temp.next;

                while (cur.val > index.val) {
                    index=index.next;
                    pre=pre.next;
                }
                //插入之间
                sorted.next=cur.next;
                cur.next=index;
                pre.next=cur;
                //恢复cur的位置
                cur=sorted.next;
            }

        }
        return temp.next;

    }
}
