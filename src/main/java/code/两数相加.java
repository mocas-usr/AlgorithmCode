package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/23 下午7:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-23 19:19
 */
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int total=l1.val+l2.val;
        int val=total%10;
        int hot=total/10;
        ListNode head=new ListNode(val);
        ListNode tmp=head;
        l1=l1.next;
        l2=l2.next;
        while (l1!=null || l2!=null || hot!=0)
        {
            if (l1==null)
            {
                l1=new ListNode(0);
            }
            if (l2==null)
            {
                l2=new ListNode(0);
            }
            //相加和
            total=l1.val+l2.val+hot;
            hot=total/10;//是否进位
            val=total%10;//此位的数值

            tmp.next=new ListNode(val);
            tmp=tmp.next;
            l1=l1.next;
            l2=l2.next;
        }
        return head;
    }

    @Test
    public void test()
    {
        ListNode node2=new ListNode(2);
        ListNode node4=new ListNode(4);
        ListNode node3=new ListNode(3);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node42=new ListNode(4);
        node2.next=node4;
        node4.next=node3;

        node5.next=node6;
        node6.next=node42;

        addTwoNumbers(node2,node5);

    }

       public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
