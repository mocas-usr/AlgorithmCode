package code.链表;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午5:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashSet;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 17:15
 */
public class 移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();

        ListNode cur = head.next;
        ListNode pre=head;
        set.add(pre.val);
        while (cur!= null) {
            if (set.contains(cur.val))
            {
                cur=cur.next;
                pre.next=cur;
            }else
            {
                set.add(cur.val);
                pre.next=cur;
                pre=pre.next;
                cur=cur.next;
            }
        }

        return head;
    }

    @Test
    public void test()
    {

    }
}
