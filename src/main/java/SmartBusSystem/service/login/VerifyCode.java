package SmartBusSystem.service.login;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Slf4j
public class VerifyCode {
    public static ArrayList<Character> alphabet = new ArrayList<>();    // 字母表
    public static ArrayList<Integer> number = new ArrayList<>();    // 数字表
    public static Random random = new Random();

    static {
        Collections.addAll(alphabet, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        Collections.addAll(alphabet, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', '0', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        Collections.addAll(number, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    public static String getVerifyCode() {
        //随机拼凑
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(alphabet.get(random.nextInt(alphabet.size())));
        }
        stringBuilder.append(number.get(random.nextInt(number.size())));
        String code = stringBuilder.toString();
        char[] codeArray = code.toCharArray();

        //打乱顺序
        int index = random.nextInt(5);
        char temp = codeArray[index];
        codeArray[index] = codeArray[codeArray.length - 1];
        codeArray[codeArray.length - 1] = temp;

        String verifyCode = new String(codeArray);
        log.info("验证码->" + verifyCode);
        return verifyCode;
    }
}
