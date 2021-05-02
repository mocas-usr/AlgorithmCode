package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午6:57
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 18:57
 */
public class 跳水板 {

    List<Integer> res;

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k==0)
        {
            return new int[0];
        }
        if (shorter==longer)
        {
            return new int[]{shorter*k};

        }

        int[] res=new int[k+1];
        for (int i=0;i<=k;i++)
        {
            res[i]=longer*i+(k-i)*shorter;
        }
        return res;

    }



    @Test
    public void test()
    {
        int shorter = 1;
        int longer = 2;
        int k = 3;
        int[] res=divingBoard(shorter, longer,k);
        System.out.println(res);
    }
}
