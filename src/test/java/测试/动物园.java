package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/7 下午8:25
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-07 20:25
 */
public class 动物园 {

    public static int[] flags;

    public static int res=Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list=new LinkedList<>();
        while (sc.hasNextLine()) {
            int i = 0;
            int n = 0;
            int s = 0;
            Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
            while (sc.hasNextLine()) {

                String[] str = sc.nextLine().split(" ");
                if (str.length > 1) {
                    Map<Integer, Integer> maptemp = new HashMap<>();
                    int n1 = Integer.valueOf(str[0]);
                    int n2 = Integer.valueOf(str[1]);
                    int length = Integer.valueOf(str[2]);
                    maptemp.put(n1, n2);
                    maptemp.put(n2, n1);
                    map.put(maptemp, length);
                } else {
                    n = Integer.valueOf(str[0]);
                    break;
                }

            }
            String[] str = sc.nextLine().split(" ");
            s = Integer.valueOf(str[0]);
            flags = new int[n];

            int res=-1;
            for (int k = 0; k < n; k++) {
                if (!dfs(k,map,0))
                {
                    res= -1;
                    break;
                }
            }

            System.out.println(res);


        }
    }

    public static boolean dfs(int index, Map<Map<Integer, Integer>, Integer> map,int sum) {

        if (flags[index] == 1) {
            //遇到环了，说明失败
            return false;
        }
        //剪枝
        if (flags[index] == -1) {
            return true;
        }
        //for 选择列表
        // 当前选择
        flags[index] = 1;

        // 下一路径


        // 恢复现场
        flags[index] = -1;
        return true;
    }
}
