import SmartBusSystem.service.SecurityProtect;

public class Encrypt {
    public static void main(String[] args) throws Exception {
        String decrypt = SecurityProtect.decrypt("RmjJCAAXqVAvr9EQsKb5jQ==");
        System.out.println(decrypt);
    }
}
