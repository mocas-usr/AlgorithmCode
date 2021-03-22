package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/2/20 20:16
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-02-20 20:16
 */
public class 杨辉三角 {

    public List<List<Integer>> generate(int numRows) {

        //结果存放
        List<List<Integer>> res=new LinkedList<>();
        //

        for (int i=0;i<numRows;i++)
        {
            //此行数据存放
            List<Integer> row=new LinkedList<>();
            for (int j=0;j<=i;j++)
            {

                if (j==0 || j==i )
                {
                    row.add(1);
                }else
                {
                    int num=res.get(i-1).get(j-1)+res.get(i-1).get(j);
                    row.add(num);
                }

            }
            res.add(row);

        }

        return res;

    }

    @Test
    public void test()
    {
        List<List<Integer>> res=generate(5);
        System.out.println(res);
    }
}
