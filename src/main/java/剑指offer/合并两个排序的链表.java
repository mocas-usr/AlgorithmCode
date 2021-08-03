package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午11:23
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 11:23
 */
public class 合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //终止条件
        if (l1==null)
        {
            return l2;
        }
        if (l2==null)
        {
            return l1;
        }
        if (l1.val<l2.val)
        {
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else
        {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
