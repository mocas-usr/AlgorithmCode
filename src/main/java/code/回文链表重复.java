package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 上午11:06
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-18 11:06
 */
public class 回文链表重复 {
    public boolean isPalindrome(ListNode head) {

        ListNode cur=head;
        Stack<ListNode> stack=new Stack<>();
        while (cur!=null)
        {
            stack.push(cur);
            cur=cur.next;
        }

        while (head!=null)
        {
            ListNode node=stack.pop();
            if (node.val!=head.val)
            {
                return false;
            }
            head=head.next;
        }
        return true;


    }
}
