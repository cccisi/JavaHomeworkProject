package project_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: cccis
 * @Date: 5/18/2018 12:46
 * @Description:
 */
public class RegEX {

    public static void main(String[] args) {
        String str = "姓名：\n" + "姓名+老师\n" + "概率：\n" + "43.6028%";
        String regEx = "姓名：\n|概率：+\\D|\\d+\\D|\n";
        System.out.print(getStringNameTeacher(str, regEx));
    }

    public static String getStringNoBlank(String str) {
        if (str != null && !"".equals(str)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            String strNoBlank = m.replaceAll("");
            return strNoBlank;
        } else {
            return str;
        }
    }

    public static String getStringNameTeacher(String str, String regEx) {
        if (str != null && !"".equals(str)) {
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            if (m.find()) {
                return m.replaceAll("");
            } else {
                return "未找到";
            }
        } else {
            return str;
        }
    }
}
