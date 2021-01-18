package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/15 13:41
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-15 13:41
 */
public class 排序链表 {

    //分治
    public ListNode sortList(ListNode head) {
        //终止条件
        if(head==null ||head.next==null)
        {
            return head;
        }

        //for 选择列表
        //做选择
        ListNode slow=head;
        ListNode fast=head.next;
        //找中点
        while (fast!=null &&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //拆分出两段
        ListNode rightHead=slow.next;//这是第二段链表的头部
        slow.next=null;//

        //下一个搜索路径
        ListNode left=sortList(head);
        ListNode right=sortList(rightHead);
        //此次结果是归一一个有序链表
        return merge(left,right);

    }

        // 合并
    public ListNode merge(ListNode left,ListNode right)
    {
        ListNode tmp=new ListNode(-1);//哨兵点
        ListNode cur=tmp;
        while (left!=null && right!=null)
        {
            if (left.val<right.val)
            {
                cur.next=left;
                left=left.next;
            }
            else
            {
                cur.next=right;
                right=right.next;
            }

            cur=cur.next;

        }
        if (left!=null)
        {
            cur.next=left;
        }else if (right!=null)
        {
            cur.next=right;
        }
        return tmp.next;


    }

       public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
