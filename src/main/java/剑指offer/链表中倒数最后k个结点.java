package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午11:18
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 11:18
 */
public class 链表中倒数最后k个结点 {

    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here

        ListNode fast=pHead;
        //先走k步
        while (k>0 && fast!=null)
        {
            fast=fast.next;
            k--;
        }
        if (k>0)
        {
            return null;
        }

        ListNode slow=pHead;

        while (fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}


