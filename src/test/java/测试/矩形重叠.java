package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/1 10:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-08-01 10:19
 */
public class 矩形重叠 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 参数为两个矩形的坐标，矩形用数组[x, y, width, height]定义，分别表示举行的横坐标，纵坐标，以及宽，高，且x,y,width,height皆为整数
     若两个矩形没有公共部分，则返回0即可
     * @param rectA int整型一维数组 第一个矩形的定义
     * @param rectB int整型一维数组 第二个矩形的定义
     * @return int整型
     */
    public int rectIntersectArea(int[] rectA, int[] rectB) {
        // write code here
        int x1 = rectA[0];
        int y1 = rectA[1];
        int x2 = rectA[2]+x1;
        int y2 = rectA[3]+y1;
        int x3 = rectB[0];
        int y3 = rectB[1];
        int x4 = rectB[2]+x3;
        int y4 = rectB[3]+y3;
        int xmin=Math.max(x1,x3);
        int ymin=Math.max(y1,y3);
        int xmax=Math.min(x2,x4);
        int ymax=Math.min(y2,y4);
        int width=xmax-xmin;
        int height=ymax-ymin;
        if (width<=0 || height<=0)
        {
            return 0;
        }else
        {
            int res=width*height;
            return res;
        }

//        int m1 = Math.max(Math.min(x1, x2), Math.min(x3, x4));
//        int n1 = Math.max(Math.min(y1, y2), Math.min(y3, y4));
//        int m2 = Math.min(Math.max(x1, x2), Math.max(x3, x4));
//        int n2 = Math.min(Math.max(y1, y2), Math.max(y3, y4));
//        if (m1 < m2 && n1 < n2) {
//            int res = (m2 - m1) * (n2 - n1);
//            return res;
//        } else {
//            return 0;
//        }
    }
    @Test
    public void test()
    {
        int[] a={0,0,10,10};
        int[] b={9,9,10,10};
        int res=rectIntersectArea(a,b);
        System.out.println(res);
    }

}
