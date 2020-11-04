package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/30 下午3:35
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-30 15:35
 */
public class 验证IP地址 {
    public String validIPAddress(String IP) {
        if (IP.length() == 0) {
            return "Neither";
        }
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] seq = IP.split("\\.");
        if (seq.length == 4) {
            for (String s : seq) {
                if (s.length() < 1 || (s.length() > 1 && s.charAt(0) == '0')) {
                    return false;
                }
                int val = getVal(s);
                if (val < 0 || val > 255) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isIPv6(String IP) {
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] seq = IP.toLowerCase().split(":");
        if (seq.length == 8) {
            for (String s : seq) {
                if (s.length() < 1 || s.length() > 4) {
                    return false;
                }
                for (char c : s.toCharArray()) {
                    if (Character.isLetter(c) && c > 'f') {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private int getVal(String s) {
        int val = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return -1;
            }
            val *= 10;
            val += c - '0';
        }
        return val;
    }
}
