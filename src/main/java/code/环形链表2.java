package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/14 21:40
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-14 21:40
 */
public class 环形链表2 {


    public ListNode detectCycle(ListNode head) {
        if (head==null)
        {
            return null;
        }

        ListNode slow=head;
        ListNode fast=head;
        ListNode index=null;

        while (fast!=null &&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)
            {
                index=slow;
                break;
            }
        }
        if (index==null)
        {
            return null;
        }

        //此时slow是相遇点
        fast=head;
        while (fast!=slow)
        {
            slow=slow.next;
            fast=fast.next;
        }

        return fast;


    }

    public ListNode detectCycle2(ListNode head) {

        if (head==null)
        {
            return null;
        }
        HashSet<ListNode> set=new HashSet<>();
        ListNode cur=head;

        while (cur!=null)
        {
            if (set.contains(cur))
            {
                return cur;
            }
            set.add(cur);
            cur=cur.next;
        }
        return null;
    }
     class ListNode {
      int val;
       ListNode next;
       ListNode(int x) {
         val = x;
          next = null;
     }
   }

}
