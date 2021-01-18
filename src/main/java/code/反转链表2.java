package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/18 15:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-18 15:19
 */
public class 反转链表2 {

    //双指针
    public ListNode reverseList(ListNode head) {

        if (head==null)
        {
            return null;
        }

        ListNode pre=null;
        ListNode cur=head;

        while (cur!=null)
        {
            //交换指针
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        return pre;
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

   @Test
    public void test()
   {
       ListNode node1=new ListNode(1);
       ListNode node2=new ListNode(2);
       ListNode node3=new ListNode(3);
       ListNode node4=new ListNode(4);
       node1.next=node2;
       node2.next=node3;
       node3.next=node4;
       ListNode res=reverseList(node1);
       System.out.println(res.val);
   }
}
