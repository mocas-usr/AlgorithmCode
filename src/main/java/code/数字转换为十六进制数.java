package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/9 下午9:08
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-09 21:08
 */
public class 数字转换为十六进制数 {
    public String toHex(int num) {

        if (num==0)
        {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        while (num != 0 && res.length() < 8) {
                //二进制与，得到10进制的数
                int temp= num & 0xf;
                res.append(chars[temp]);
                num>>=4;
        }

        return res.reverse().toString();


    }
}
