package SmartBusSystem.service.login;

public interface Login {
    boolean verifyID(String ID);

    boolean verifyPassword(String ID, String password) throws Exception;

    boolean verifyVerifyCode(String code, String rightCode);
}
