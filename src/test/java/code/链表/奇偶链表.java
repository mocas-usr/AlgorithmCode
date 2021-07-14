package code.链表;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午5:17
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 17:17
 */
public class 奇偶链表 {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode oushuHead = head.next;
        //初始化指针
        ListNode jishu = head;
        ListNode oushu = head.next;

        while (oushu != null && oushu.next != null) {
            jishu.next = oushu.next;
            jishu = jishu.next;
            oushu.next = jishu.next;
            oushu = oushu.next;
        }

        jishu.next = oushuHead;
        return head;
    }


}
