package code.分治;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 上午10:50
 * @email: wangyuhang_mocas@163.com
 */

import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 10:50
 */
public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        //下一路径
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeList(l1, l2);

    }

    public ListNode mergeList(ListNode l1, ListNode l2) {

        if (l1==null)
        {
            return l2;
        }
        if (l2==null)
        {
            return l1;
        }
        if (l1.val<l2.val)
        {
            l1.next=mergeList(l1.next,l2);
            return l1;
        }else
        {
            l2.next=mergeList(l1,l2.next);

            return l2;
        }

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
