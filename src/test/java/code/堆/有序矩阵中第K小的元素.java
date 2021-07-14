package code.堆;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:55
 * @email: wangyuhang_mocas@163.com
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 19:55
 */
public class 有序矩阵中第K小的元素 {
    //小顶堆做
    public int kthSmallest(int[][] matrix, int k) {

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                queue.add(matrix[i][j]);
            }

        int num = 0;
        while (k > 0) {
            k--;
            num = queue.poll();
        }
        return num;


    }

    //大顶堆
    public int kthSmallest2(int[][] matrix, int k) {

        Queue<Integer> queue = new PriorityQueue<>((x1, x2) -> (x2 - x1));

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {


                if (queue.size() >= k) {
                    if (matrix[i][j] < queue.peek()) {
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }
                }else
                {
                    queue.add(matrix[i][j]);
                }

            }
        return queue.peek();

    }
}
