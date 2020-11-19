package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午10:25
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 10:25
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {

        if (head==null)
        {
            return null;
        }

        ListNode temp=new ListNode(val+1);
        temp.next=head;
        ListNode  cur=temp;
        while (cur!=null &&cur.next!=null)
        {
            if (cur.next.val==val)
            {
                cur.next=cur.next.next;
            }
            //移动
            cur=cur.next;
        }
        return temp.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
