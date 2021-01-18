package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/13 22:14
 * @email: wangyuhang_mocas@163.com
 */

import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-13 22:14
 */
public class 环形链表 {
    //双指针
    public boolean hasCycle(ListNode head) {
        if (head==null)
        {
            return false;
        }

        ListNode left=head;//慢指针
        ListNode right=head;//快指针
        while (right!=null && right.next!=null)
        {
            left=left.next;
            right=right.next.next;
            if (left==right)
            {
                return true;
            }
        }
        return false;

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
