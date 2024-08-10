package SmartBusSystem.service.recover;

public interface Recover {
    boolean verifyID(String ID);

    boolean verifyPhoneNum(String ID, String phoneNum);

    boolean checkPassword(String password);

    void resetPassword(String ID, String newPassword);
}
