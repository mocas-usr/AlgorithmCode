package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/19 20:03
 * @email: wangyuhang_mocas@163.com
 */

import code.两数相加;
import org.junit.Test;

import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-19 20:03
 */
public class testClass {
    public ListNode reverse(ListNode head) {

        //终止
        if (head == null) {
            return null;
        }

        //初始化三指针
        ListNode pre = head;
        ListNode cur = head.next;
        //
        ListNode next = null;

        //
        while (cur != null) {

            //指针位置
            next=cur.next;
            cur.next=pre;

            pre=cur;
            cur=next;

        }
        //终止跳出
        head.next=null;
        //起始终点
        return pre;

    }

    @Test
    public void test() {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        node1.next=node2;
        ListNode res=reverse(node1);
        System.out.println(res);
    }

    static class ListNode {
        int val;

        ListNode(int val) {
            this.val = val;
        }

        ListNode next = null;
    }
}
