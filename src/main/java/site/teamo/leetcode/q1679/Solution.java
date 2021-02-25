package site.teamo.leetcode.q1679;

/**
 * @author 爱做梦的锤子
 * @create 2021/1/8
 */

/**
 * 1678. 设计 Goal 解析器
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 */

public class Solution {
    public String interpret(String command) {
        int flag = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char temp = command.charAt(i);
            if (temp == 'G') {
                sb.append('G');
                continue;
            }
            if (temp == '(') {
                flag = i;
                continue;
            }
            if (temp == ')') {
                if (i - flag == 1) {
                    sb.append('o');
                }
                continue;
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public String interpret2(String command) {
        return command.replace("()","o").replace("(a1)","a1");
    }
}
