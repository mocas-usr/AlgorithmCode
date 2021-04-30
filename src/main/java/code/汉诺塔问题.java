package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/30 下午7:41
 * @email: wangyuhang_mocas@163.com
 */

import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-30 19:41
 */
public class 汉诺塔问题 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A.size(), A, B, C);
    }


    public void dfs(int num, List<Integer> A, List<Integer> B, List<Integer> C) {
        //终止条件
        if (num==1)
        {
            C.add(A.remove(A.size()-1));
            return;
        }
        //循环列表
        //当前选择
        //下一路径
        //先移动num-1个到中间的
        dfs(num-1,A,C,B);
        //再移动第num个到A
        C.add(A.remove(A.size()-1));
        dfs(num-1,B,A,C);

    }
}
