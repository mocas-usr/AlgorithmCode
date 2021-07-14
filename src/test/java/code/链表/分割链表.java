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

        if (head==null)
        {
            return null;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-2);
        //指针
        ListNode cur = head;
        ListNode small = smallHead;
        ListNode big = bigHead;

        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            if (cur.val >= x) {
                big.next = node;
                big=big.next;
            }else
            {
                small.next=node;
                small=small.next;
            }
            cur = cur.next;
        }
        //连接
        small.next=bigHead.next;
        return smallHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
