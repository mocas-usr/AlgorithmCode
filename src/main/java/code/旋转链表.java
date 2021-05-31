package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/21 下午12:13
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-21 12:13
 */
public class 旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)
        {
            return null;
        }
        int num = 0;
        ListNode cur = head;
        //计数多少个节点
        while (cur.next != null) {
            num++;
            cur = cur.next;

        }
        num++;
        //成环
        cur.next = head;

        //移动到最后一个节点

        int n = num - k % num;

        while (n > 0) {
            cur = cur.next;
            n--;
        }

        //断开
        ListNode newHead=cur.next;
        cur.next=null;
        return newHead;


    }
}
