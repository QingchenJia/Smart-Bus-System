package SmartBusSystem.service.register;

public interface Register {
    boolean containObject(String ID);

    boolean checkID(String ID);

    boolean checkPassword(String password);

    boolean checkPhoneNum(String phoneNum);

    void register(Object object);
}
