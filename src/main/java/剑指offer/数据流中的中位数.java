package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午5:09
 * @email: wangyuhang_mocas@163.com
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-17 17:09
 */
public class 数据流中的中位数 {
    //双队列
    Queue<Integer> max=new PriorityQueue<>();//小顶堆
    Queue<Integer> min=new PriorityQueue<>(((o1, o2) -> (o2-o1)));//大顶堆

    public void Insert(Integer num) {

        if (min.size()==max.size())
        {
            min.offer(num);
            max.offer(min.poll());
        }else
        {
            max.offer(num);
            min.offer(max.poll());
        }

    }

    public Double GetMedian() {
        if (max.size()==min.size())
        {
            return (double)(max.peek()+min.peek())/2;
        }else
        {
            return (double)max.peek();
        }
    }
}
