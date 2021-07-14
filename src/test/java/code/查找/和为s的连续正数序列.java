package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午3:34
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 15:34
 */
public class 和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        if (target==1)
        {
            return new  int[][]{{1}};
        }
        List<LinkedList<Integer>> res=new LinkedList<>();

        int left=1;
        int right=target;
        int sum=0;
        while (left<right)
        {
            sum=0;
            LinkedList<Integer> list=new LinkedList<>();
            for (int i=left;i<=right;i++)
            {
                sum+=i;
                list.add(i);
            }
            if (sum>target)
            {
                right--;
            }else if (sum<target)
            {
                left++;
            }else
            {
                res.add(list);
                right--;
                left++;
            }
        }


        return  res.toArray(new int[res.size()][]);

    }
}
