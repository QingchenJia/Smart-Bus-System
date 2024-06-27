package SmartBusSystem.pojo;

public class Driver {
    private String ID;
    private String password;
    private String name;
    private int drivingYears;
    private String phoneNum;

    public Driver() {
    }

    public Driver(String ID, String password, String name, int drivingYears, String phoneNum) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.drivingYears = drivingYears;
        this.phoneNum = phoneNum;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrivingYears() {
        return drivingYears;
    }

    public void setDrivingYears(int drivingYears) {
        this.drivingYears = drivingYears;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Driver{" + "ID='" + ID + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + ", drivingYears=" + drivingYears + ", phoneNum='" + phoneNum + '\'' + '}';
    }
}
