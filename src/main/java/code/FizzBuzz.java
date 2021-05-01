package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/16 下午5:00
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-16 17:00
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {

        List<String> res=new LinkedList<>();
        for (int i=1;i<=n;i++)
        {
            if (i%3==0 && i%5==0)
            {
                res.add("FizzBuzz");
            }else if (i%5==0)
            {
                res.add("Buzz");
            }else if (i%3==0)
            {
                res.add("Fizz");
            }else
            {
                res.add(String.valueOf(i));
            }
        }
        return res;

    }
}
