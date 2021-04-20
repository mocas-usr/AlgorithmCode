package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午7:45
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 19:45
 */
public class 分割链表 {
    public ListNode partition(ListNode head, int x) {

        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode big = bigHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val<x)
            {
                small.next=cur;
                small=small.next;
            }else
            {
                big.next=cur;
                big=big.next;
            }
            cur=cur.next;

        }
        big.next=null;
        small.next=bigHead.next;

        return smallHead.next;


    }
}
