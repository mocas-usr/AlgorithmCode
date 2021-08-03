package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 下午8:25
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-25 20:25
 */
public class 牌 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ListNode chicken = new ListNode(0);
        ListNode duck = new ListNode(0);
        ListNode p = chicken;
        ListNode q = duck;

        for (int i = 0; i < N; i++) {
            int chickenVal = scanner.nextInt();
            p.next = new ListNode(chickenVal);
            p = p.next;
        }
        for (int i = 0; i < N; i++) {
            int duckVal = scanner.nextInt();
            q.next = new ListNode(duckVal);
            q = q.next;
        }
        //多多鸡筹码
        int chickenCount = 0;
        //多多鸭筹码
        int duckCount = 0;

        ListNode desk = new ListNode(0);
        ListNode r = desk;
        while (chicken.next != null && duck.next != null) {
            //多多鸡出一张
            ListNode temp1 = chicken.next;
            chicken.next = chicken.next.next;
            temp1.next = null;
            r.next = temp1;
            r = r.next;
            //计算筹码
            ListNode pre = desk;
            ListNode cur = desk.next;
            while (cur != null && cur != temp1 && cur.val != temp1.val) {
                cur = cur.next;
                pre = pre.next;
            }
            if (cur != temp1) {
                chickenCount += countLen(cur);
                pre.next = null;
                r = pre;
            }
            //多多鸭出一张
            ListNode temp2 = duck.next;
            duck.next = duck.next.next;
            temp2.next = null;
            r.next = temp2;
            r = r.next;
            //计算筹码
            ListNode pre2 = desk;
            ListNode cur2 = desk.next;
            while (cur2 != null && cur2 != temp2 && cur2.val != temp2.val) {
                cur2 = cur2.next;
                pre2 = pre2.next;
            }
            if (cur2 != temp2) {
                duckCount += countLen(cur2);
                pre2.next = null;
                r = pre2;
            }

        }
        r.next = chicken.next == null ? duck.next : chicken.next;

        ListNode deskNext = desk.next;

        while (deskNext != null) {
            if (deskNext.val % 2 == 0) {
                duckCount++;
            } else {
                chickenCount++;
            }
            deskNext = deskNext.next;
        }
        System.out.println(chickenCount + " " + duckCount);

    }

    public static int countLen(ListNode cur) {
        int count = 0;
        ListNode p = cur;
        while (p != null) {
            count++;
            p = p.next;
        }

        return count;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }
}
