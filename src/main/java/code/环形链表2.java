package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/14 21:40
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;

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

        HashSet<ListNode> set=new HashSet<>();
        ListNode tmp=head;
        while (tmp!=null)
        {
            if (set.contains(tmp))
            {
                return tmp;
            }
            set.add(tmp);
            tmp=tmp.next;
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
