package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 下午7:56
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-18 19:56
 */
public class 二进制数转字符串 {

    public String printBin(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num != 0) {
            num*=2;
            if (num>=1)
            {
                sb.append(1);
                num--;

            }else
            {
                sb.append(0);
            }
            if(sb.length() > 32){
                return "ERROR";
            }


        }
        return sb.toString();

    }
}
