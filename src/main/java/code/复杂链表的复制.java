package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 上午9:40
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-07 09:40
 */
public class 复杂链表的复制 {
    //深拷贝，相当于复制全新的,时间o(n),空间o（n）
    public Node copyRandomList(Node head) {
        //key代表老节点，value代表新节点
        HashMap<Node,Node> map=new HashMap<>();
        Node cur=head;//指针
        while (cur!=null)
        {
            map.put(cur,new Node(cur.val));//新老节点的对应关系
            cur=cur.next;
        }

        cur=head;
        while (cur!=null)
        {
            map.get(cur).next=map.get(cur.next);//指向下一个节点
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);

    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
