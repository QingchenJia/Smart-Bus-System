import SmartBusSystem.Util.CipherUtil;
import org.junit.Test;

public class DemoMethodTest {
    @Test
    public void testEncrypt() throws Exception {
        String text = "123abc";

        String encrypt = CipherUtil.encrypt(text);
        System.out.println(("密文:" + encrypt));

        String decrypt = CipherUtil.decrypt(encrypt);
        System.out.println(("明文:" + decrypt));
    }
}
