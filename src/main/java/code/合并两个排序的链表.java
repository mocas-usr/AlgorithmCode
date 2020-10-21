package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/19 下午3:31
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-19 15:31
 */
/*输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。*/
public class 合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建伪头部
        ListNode head = new ListNode(0);
        ListNode cur;
        //深克隆
        cur = head;//初始化指向头部
        while (l1 != null && l2 != null)//这个
        {

            if (l2.val < l1.val)//取其中较小的
            {
                cur.next = l2;
                //指针右移
                cur = cur.next;
                l2 = l2.next;

            } else {
                //指针左移
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        //如果有一个为空，则剩下的直接接上去
        cur.next = l2 != null ? l2 : l1;
        //深克隆，浅克隆
        return head.next;

    }
}

