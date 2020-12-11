package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/19 下午5:03
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-19 17:03
 */
public class 反转链表 {
    //双指针
    public ListNode reverseList(ListNode head) {

        if (head==null)
        {
            return null;
        }
        ListNode pre=head;
        ListNode cur=pre.next;
        ListNode next=null;
        //双指针
        while (pre!=null &&cur!=null)
        {
            //指针位置
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        head.next=null;
        return pre;
    }
     public class ListNode {
       int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
}
