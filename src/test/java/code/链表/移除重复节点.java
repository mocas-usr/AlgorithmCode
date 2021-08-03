package code.链表;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午5:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 17:15
 */
public class 移除重复节点 {

    public ListNode removeDuplicateNodes(ListNode head) {

        if (head==null)
        {
            return null;
        }
        Set<Integer> set=new HashSet<>();
        ListNode temp=new ListNode(-1);
        ListNode cur=head;
        ListNode pre=temp;
        while (cur!=null)
        {
            if (set.contains(cur.val))
            {
                cur=cur.next;
                pre.next=cur;

            }else
            {
                set.add(cur.val);
                pre.next=cur;
                cur=cur.next;
                pre=pre.next;
            }
        }
        return temp.next;

    }

    @Test
    public void test()
    {

    }
}
