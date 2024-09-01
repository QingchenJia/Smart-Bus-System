import SmartBusSystem.Util.SecurityProtect;
import org.junit.Test;

public class DemoMethodTest {
    @Test
    public void testEncrypt() throws Exception {
        String text = "123abc";

        String encrypt = SecurityProtect.encrypt(text);
        System.out.println(("密文:" + encrypt));

        String decrypt = SecurityProtect.decrypt(encrypt);
        System.out.println(("明文:" + decrypt));
    }
}
